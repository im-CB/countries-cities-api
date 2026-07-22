package com.cb.countriescities.service.impl;

import com.cb.countriescities.dto.CityDetailResponse;
import com.cb.countriescities.dto.CitySummaryResponse;
import com.cb.countriescities.dto.CountryResponse;
import com.cb.countriescities.dto.PageResponse;
import com.cb.countriescities.entity.City;
import com.cb.countriescities.entity.Country;
import com.cb.countriescities.exception.ResourceNotFoundException;
import com.cb.countriescities.repository.CityRepository;
import com.cb.countriescities.repository.CountryRepository;
import com.cb.countriescities.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    @Override
    public PageResponse<CitySummaryResponse> getCitiesByCountry(
            Long countryId,
            int page,
            int size) {

        validateCountryExists(countryId);

        List<City> cities = cityRepository.findByCountryId(countryId);

        int totalElements = cities.size();

        int fromIndex = page * size;

        if (fromIndex >= totalElements) {
            return PageResponse.<CitySummaryResponse>builder()
                    .content(List.of())
                    .page(page)
                    .size(size)
                    .totalElements(totalElements)
                    .totalPages((int) Math.ceil((double) totalElements / size))
                    .build();
        }

        int toIndex = Math.min(fromIndex + size, totalElements);

        List<CitySummaryResponse> content = cities.subList(fromIndex, toIndex)
                .stream()
                .map(this::mapToCitySummary)
                .toList();

        return PageResponse.<CitySummaryResponse>builder()
                .content(content)
                .page(page)
                .size(size)
                .totalElements(totalElements)
                .totalPages((int) Math.ceil((double) totalElements / size))
                .build();
    }

    @Override
    public CityDetailResponse getCityById(Long cityId) {

        City city = cityRepository.findById(cityId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("City not found with id: " + cityId));

        Country country = countryRepository.findById(city.getCountryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Country not found with id: " + city.getCountryId()));

        return mapToCityDetail(city, country);
    }

    /* ---------- Private Methods ---------- */

    private void validateCountryExists(Long countryId) {
        countryRepository.findById(countryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Country not found with id: " + countryId));
    }

    private CitySummaryResponse mapToCitySummary(City city) {
        return CitySummaryResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .build();
    }

    private CityDetailResponse mapToCityDetail(City city, Country country) {

        return CityDetailResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .population(city.getPopulation())
                .zipCode(city.getZipCode())
                .description(city.getDescription())
                .country(mapToCountryResponse(country))
                .build();
    }

    private CountryResponse mapToCountryResponse(Country country) {

        return CountryResponse.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }
}