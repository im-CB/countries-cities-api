// package com.cb.countriescities.repository;

// import org.springframework.stereotype.Component;

// @Component
// public class DataStore {
// }

package com.cb.countriescities.repository;

import com.cb.countriescities.entity.City;
import com.cb.countriescities.entity.Country;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataStore {

    private final List<Country> countries = new ArrayList<>();
    private final List<City> cities = new ArrayList<>();

    @PostConstruct
    public void loadData() {

        countries.add(new Country(1L, "India"));
        countries.add(new Country(2L, "United States"));
        countries.add(new Country(3L, "Canada"));

        cities.add(new City(1L, "Chennai", 1L, 7090000L, "600001", "Capital of Tamil Nadu"));
        cities.add(new City(2L, "Bengaluru", 1L, 8440000L, "560001", "Silicon Valley of India"));
        cities.add(new City(3L, "Hyderabad", 1L, 6990000L, "500001", "City of Pearls"));
        cities.add(new City(4L, "Mumbai", 1L, 12400000L, "400001", "Financial Capital of India"));
        cities.add(new City(5L, "Delhi", 1L, 11000000L, "110001", "Capital of India"));

        cities.add(new City(6L, "New York", 2L, 8419000L, "10001", "Largest city in USA"));
        cities.add(new City(7L, "Los Angeles", 2L, 3980000L, "90001", "Entertainment capital"));
        cities.add(new City(8L, "Chicago", 2L, 2695000L, "60601", "Known for architecture"));

        cities.add(new City(9L, "Toronto", 3L, 2930000L, "M5H", "Largest city in Canada"));
        cities.add(new City(10L, "Vancouver", 3L, 675000L, "V5K", "Beautiful coastal city"));
    }
}