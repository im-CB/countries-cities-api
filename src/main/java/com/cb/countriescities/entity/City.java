package com.cb.countriescities.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private Long id;

    private String name;

    private Long countryId;

    private Long population;

    private String zipCode;

    private String description;

}