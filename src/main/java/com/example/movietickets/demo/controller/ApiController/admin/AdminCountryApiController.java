package com.example.movietickets.demo.controller.ApiController.admin;

import com.example.movietickets.demo.model.Country;
import com.example.movietickets.demo.service.APIService.AdminApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminCountryApiController {

    @Autowired
    private AdminApiService adminApiService;

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        Optional<Country> country = adminApiService.getCountryById(id);
        return country.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return adminApiService.getAllCountry();
    }
}
