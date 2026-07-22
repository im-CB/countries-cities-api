package com.cb.countriescities.controller;

import com.cb.countriescities.dto.CityDetailResponse;
import com.cb.countriescities.dto.CitySummaryResponse;
import com.cb.countriescities.dto.PageResponse;
import com.cb.countriescities.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
@Tag(name = "Cities", description = "City APIs")
public class CityController {

    private final CityService cityService;

    @GetMapping("/countries/{countryId}/cities")
    @Operation(summary = "Get cities by country with pagination")
    public ResponseEntity<PageResponse<CitySummaryResponse>> getCitiesByCountry(
            @PathVariable @Min(1) Long countryId,
            @RequestParam(defaultValue = "0") @Min(0) int page,
            @RequestParam(defaultValue = "5") @Min(1) int size) {

        return ResponseEntity.ok(
                cityService.getCitiesByCountry(countryId, page, size)
        );
    }

    @GetMapping("/cities/{cityId}")
    @Operation(summary = "Get city details by id")
    public ResponseEntity<CityDetailResponse> getCityById(
            @PathVariable @Min(1) Long cityId) {

        return ResponseEntity.ok(
                cityService.getCityById(cityId)
        );
    }
}