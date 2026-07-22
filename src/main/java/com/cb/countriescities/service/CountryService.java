package com.cb.countriescities.service;

import com.cb.countriescities.dto.CountryResponse;

import java.util.List;

public interface CountryService {

    List<CountryResponse> getAllCountries();

}