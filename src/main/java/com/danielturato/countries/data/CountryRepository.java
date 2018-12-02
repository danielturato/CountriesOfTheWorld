package com.danielturato.countries.data;

import com.danielturato.countries.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class CountryRepository {
    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
            new Country("Ecuador", 16.62, "Quito", Arrays.asList("Spanish")),
            new Country("France", 67.12, "Paris", Arrays.asList("French", "Basque")),
            new Country("India", 1300.39, "New Delhi", Arrays.asList("Hindi", "English", "Urdu",
                                                                                "Bengali", "Punjabi", "Sanskrit", "Tamil",
                                                                                "Kannada", "Maithilli", "Telugu", "Gujarati")),
            new Country("Italy", 60.59, "Rome", Arrays.asList("Italian")),
            new Country("Kenya", 49.7, "Nairobi", Arrays.asList("Swahilli", "English"))
    );

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public Country getCountryByName(String name) {
        return ALL_COUNTRIES.stream()
                            .filter(c -> c.getName().equalsIgnoreCase(name))
                            .findFirst()
                            .orElse(null);
    }

    public void sortBy(String value) {
        if (value.equalsIgnoreCase("name")) {
            Collections.sort(ALL_COUNTRIES, Comparator.comparing(Country::getName));
        } else {
            Collections.sort(ALL_COUNTRIES, Comparator.comparingDouble(Country::getPopulation).reversed());
        }

    }
}
