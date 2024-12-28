package com.example.MyController;


import com.example.Entity.Teslim_Sureleri;
import com.example.Entity.Yanıt_Dto;
import com.example.Repository.Teslim_Sureleri_Repository;
import com.example.service.AllService;
import org.springframework.web.bind.annotation.*;
import com.example.Repository.Teslim_Sureleri_Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class Controller {
        private final AllService allService;


        public Controller(AllService allService) {
                this.allService = allService;
        }
        @GetMapping(path = "/")
        public List<Yanıt_Dto> getTeslimSureleri(@org.jetbrains.annotations.NotNull @RequestBody Teslim_Sureleri teslimSureleri) {
                return allService.getTeslim_Sureleri(teslimSureleri.getVaris_ili() ,
                        teslimSureleri.getKabul_ili());
        }
}


