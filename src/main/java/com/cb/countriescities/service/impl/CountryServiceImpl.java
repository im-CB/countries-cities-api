package com.cb.countriescities.service.impl;

import com.cb.countriescities.dto.CountryResponse;
import com.cb.countriescities.entity.Country;
import com.cb.countriescities.repository.CountryRepository;
import com.cb.countriescities.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<CountryResponse> getAllCountries() {

        return countryRepository.findAll()
                .stream()
                .map(this::mapToCountryResponse)
                .toList();
    }

    private CountryResponse mapToCountryResponse(Country country) {
        return CountryResponse.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }
}