package com.example.webservice.controller;

import com.example.webservice.model.Province;
import com.example.webservice.service.ICountryService;
import com.example.webservice.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    private ICountryService iCountryService;

    @Autowired
    private IProvinceService iProvinceService;

    @GetMapping
    public ResponseEntity<List<Province>> findAll() {
        List<Province> provinces = iProvinceService.findAll();
        if (provinces.isEmpty()) {
            return new ResponseEntity<>(provinces,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(provinces, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Province> creatProvince(@RequestBody Province province) {
        Province provinceCreate = iProvinceService.save(province);
        return new ResponseEntity<>(provinceCreate, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Province> updateProvince(@RequestBody Province province) {
        Optional<Province> provinceUpdate = iProvinceService.findById(province.getId());
        if (provinceUpdate.isPresent()) {
            Province update = iProvinceService.save(province);
            return new ResponseEntity<>(update, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Province> findById(@PathVariable("id") Long id) {
        Optional<Province> province = iProvinceService.findById(id);
        if (province.isPresent()) {
            return new ResponseEntity<>(province.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Province> delete(@PathVariable("id") Long id) {
        Optional<Province> province = iProvinceService.findById(id);
        if (province.isPresent()) {
            iProvinceService.delete(id);
            return new ResponseEntity<>(province.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
