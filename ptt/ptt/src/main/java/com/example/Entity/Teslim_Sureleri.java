package com.example.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="teslim_sureleri")

public class Teslim_Sureleri {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "gun")
    private int gun;
    @Column(name = "cut_off_time")
    private LocalTime cut_off_time;
    @Column(name = "kabul_ili")
    private int kabul_ili;
    @Column(name = "varis_ili")
    private int varis_ili;
    @Column(name = "gonderi_turu")
    private String gonderi_turu;
    @Column(name = "varıs_gunu")
    private String varıs_gunu;
}
