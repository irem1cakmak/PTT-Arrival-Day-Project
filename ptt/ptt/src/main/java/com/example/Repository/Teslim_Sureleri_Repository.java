package com.example.Repository;


import com.example.Entity.Teslim_Sureleri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface Teslim_Sureleri_Repository extends JpaRepository<Teslim_Sureleri, Integer> {
      @Query("SELECT t FROM Teslim_Sureleri t WHERE t.varis_ili = :varis_ili AND t.kabul_ili = :kabul_ili")
      List<Teslim_Sureleri> findByVaris_iliAndKabul_ili(int varis_ili, int kabul_ili);
}
//          Optional<Teslim_Sureleri>findByTeslim_SureleriByVaris_iliAndKabul_ili(int varis_ili, int kabul_ili) ;