package com.example.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Yanıt_Dto {
//  private int id;
    private int gun;
    private String varıs_gunu;

    private String gonderi_turu;
    private String cut_off_time;

}
