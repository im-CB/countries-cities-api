package com.cb.countriescities.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDetailResponse {

    private Long id;

    private String name;

    private Long population;

    private String zipCode;

    private String description;

    private CountryResponse country;

}