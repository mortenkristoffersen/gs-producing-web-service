package com.example.gui;

import com.example.producingwebservice.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CountryController {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/country")
    public String country(@RequestParam(name="name", required=false, defaultValue="Spain") String name, Model model) {
        var country = countryRepository.findCountry(name);
        model.addAttribute("country", country);
        return "country";
    }
}
