package com.example.movietickets.demo.service;


import com.example.movietickets.demo.model.Category;
import com.example.movietickets.demo.model.Country;
import com.example.movietickets.demo.repository.CountryRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
//khởi tạo constructor tự động

public class CountryService {
    private final CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAllByOrderByIdDesc();
    }

    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }
    @Transactional
    public void updateCountry(@NotNull Country country) {
        Country existingCountry = countryRepository.findById(country.getId())
                .orElseThrow(() -> new IllegalStateException("Country with ID " + country.getId() + " does not exist."));
        existingCountry.setName(country.getName());
        countryRepository.save(existingCountry);
    }

    public void deleteCountry(Long id) {
        if (!countryRepository.existsById(id)) {
            throw new IllegalStateException("Country with ID " + id + " does not exist.");
        }
        countryRepository.deleteById(id);
    }

    public boolean existsCountryByName(String name) {
        return countryRepository.existsCountryByName(name.toLowerCase());
    }

}
