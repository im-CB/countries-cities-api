package com.cb.countriescities.service;

import com.cb.countriescities.dto.CityDetailResponse;
import com.cb.countriescities.dto.CitySummaryResponse;
import com.cb.countriescities.dto.PageResponse;

public interface CityService {

    PageResponse<CitySummaryResponse> getCitiesByCountry(
            Long countryId,
            int page,
            int size
    );

    CityDetailResponse getCityById(Long cityId);

}