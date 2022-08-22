package com.example.webservice.service.impl;

import com.example.webservice.model.Province;
import com.example.webservice.repository.IProvinceRepository;
import com.example.webservice.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public Province save(Province province) {
        return iProvinceRepository.save(province);
    }

    @Override
    public void delete(Long id) {
        iProvinceRepository.deleteById(id);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return iProvinceRepository.findById(id);
    }

    @Override
    public List<Province> findAll() {
        return iProvinceRepository.findAll();
    }

    @Override
    public Page<Province> pageProvinces(Pageable pageable) {
        return iProvinceRepository.findAll(pageable);
    }

    @Override
    public Page<Province> pageProvincesByNameSearch(String name, Pageable pageable) {
        return iProvinceRepository.searchPage("%" + name + "%", pageable);
    }

    @Override
    public Page<Province> pageProvincesByCountry(Long id, Pageable pageable) {
        return iProvinceRepository.findAllByCountry_Id(id, pageable);
    }

    @Override
    public List<Province> top3LessPopular() {
        return iProvinceRepository.findTop3ByOrderByPopular();
    }

    @Override
    public List<Province> top3GreatArea() {
        return iProvinceRepository.findTop3ByOrderByAreaDesc();
    }
}
