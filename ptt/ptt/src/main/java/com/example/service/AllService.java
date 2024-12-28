package com.example.service;

import com.example.Entity.Teslim_Sureleri;
import com.example.Entity.Yanıt_Dto;
import com.example.Repository.Teslim_Sureleri_Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AllService {
    private final Teslim_Sureleri_Repository teslim_Sureleri_Repository;

    public AllService(Teslim_Sureleri_Repository teslim_Sureleri_Repository) {
        this.teslim_Sureleri_Repository = teslim_Sureleri_Repository;
    }
//    public Optional<Teslim_Sureleri> GetTeslim(int varıs_ili,int kabul_ili) {
//        return teslim_Sureleri_Repository.queryTeslim_SureleriByVaris_iliAndKabul_ili(varıs_ili,kabul_ili);
//    }

//        public List<Teslim_Sureleri> GetTeslim(int varis_ili,int kabul_ili) {
//        return teslim_Sureleri_Repository.findByVaris_iliAndKabul_ili(varis_ili,kabul_ili);
//    }

    public List<Yanıt_Dto> getTeslim_Sureleri(int varis_ili,int kabul_ili) {
        List<Teslim_Sureleri> sureleri=teslim_Sureleri_Repository.findByVaris_iliAndKabul_ili(varis_ili,kabul_ili);
//        if (sureleri == null || sureleri.isEmpty()) {
//            return Collections.emptyList();
//        }
        return  sureleri.stream().map(t -> new Yanıt_Dto(
                        t.getGun(),
                        hesaplaVarisGunu(t.getGun(), t.getCut_off_time()),
//                         t.getVarıs_gunu(),
                        t.getGonderi_turu(),
                        t.getCut_off_time().toString()))
                .collect(Collectors.toList());
    }
    /**
     * Cut-off time'a göre varış gününü hesaplayan fonksiyon
     */
//    private Integer hesaplaVarisGunu(int gun, LocalTime cutOffTime) {
//        LocalTime seventeenOClock = LocalTime.of(17, 0);  // 17:00 saati
//
//        if (cutOffTime.isBefore(seventeenOClock)) {
//            return gun + 1;  // 17:00'dan küçükse gün + 1
//        } else {
//            return gun + 2;  // 17:00 veya büyükse gün + 2
//        }
//    }
    private String hesaplaVarisGunu(int gun, LocalTime cutOffTime) {
        List<String> days = Arrays.asList(
                "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"
        );

        LocalTime seventeenOClock = LocalTime.of(17, 0); // 17:00
        LocalDate today = LocalDate.now(); // Bugünün tarihi

        // Eğer şu anki zaman 17:00'dan önceyse, bugünün adını döndürüyoruz.
        if (cutOffTime.isBefore(seventeenOClock)) {
            int currentDayIndex = today.getDayOfWeek().getValue() - 1; // DayOfWeek enum'ı Pazartesi için 1 döner
            int calculatedIndex = (currentDayIndex + gun) % 6; // 0-5 arasında bir değer alır (Pazar hariç)
            return days.get(calculatedIndex);
        } else {
            // 17:00'den sonra ise ertesi gün olacak şekilde günü hesaplıyoruz.
            int nextDayIndex = (today.getDayOfWeek().getValue()) % 6; // Ertesi günün index'i (Pazar hariç)
            int calculatedIndex = (nextDayIndex + gun) % 6; // 0-5 arasında bir değer alır (Pazar hariç)
            return days.get(calculatedIndex);
        }
    }
}


// t.getCut_off_time().toString()
//t.getCut_off_time()!= null ? t.getCut_off_time().toString() : ""