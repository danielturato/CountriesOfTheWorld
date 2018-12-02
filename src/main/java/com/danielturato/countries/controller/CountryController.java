package com.danielturato.countries.controller;

import com.danielturato.countries.data.CountryRepository;
import com.danielturato.countries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @RequestMapping("/countries")
    public String listCountriesSort(@RequestParam(value = "sortBy", defaultValue = "name") String sortBy,ModelMap modelMap) {
        List<Country> countries = countryRepository.getAllCountries();
        if (sortBy.equalsIgnoreCase("name")) {
            countryRepository.sortBy("name");
        } else {
            countryRepository.sortBy("population");
        }
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping("/country/{name}")
    public String countryDetails(@PathVariable String name, ModelMap modelMap) {
        modelMap.put("country", countryRepository.getCountryByName(name));
        return "country";
    }
}
