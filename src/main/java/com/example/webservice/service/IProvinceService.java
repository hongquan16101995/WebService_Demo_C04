package com.example.webservice.service;

import com.example.webservice.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProvinceService extends ICRUDService<Province, Long> {
    Page<Province> pageProvinces(Pageable pageable);

    Page<Province> pageProvincesByNameSearch(String name,Pageable pageable);

    Page<Province> pageProvincesByCountry(Long id, Pageable pageable);

    List<Province> top3LessPopular();

    List<Province> top3GreatArea();
}
