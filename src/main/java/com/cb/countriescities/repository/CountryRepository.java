package com.cb.countriescities.repository;

import com.cb.countriescities.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CountryRepository {

    private final DataStore dataStore;

    public List<Country> findAll() {
        return dataStore.getCountries();
    }

    public Optional<Country> findById(Long id) {
        return dataStore.getCountries()
                .stream()
                .filter(country -> country.getId().equals(id))
                .findFirst();
    }
}