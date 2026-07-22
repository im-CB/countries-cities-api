package com.cb.countriescities.repository;

import com.cb.countriescities.entity.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CityRepository {

    private final DataStore dataStore;

    public List<City> findByCountryId(Long countryId) {
        return dataStore.getCities()
                .stream()
                .filter(city -> city.getCountryId().equals(countryId))
                .toList();
    }

    public Optional<City> findById(Long cityId) {
        return dataStore.getCities()
                .stream()
                .filter(city -> city.getId().equals(cityId))
                .findFirst();
    }
}