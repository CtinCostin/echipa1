package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.echipa1.entities.Country;
import ro.sda.echipa1.service.CityService;
import ro.sda.echipa1.service.ContinentService;
import ro.sda.echipa1.service.CountryService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private ContinentService continentService;
//    @Autowired
//    private CityService cityService;


    @GetMapping("/country")
    public String showCountriesPage(Model model) {
        List<Country> countryList = countryService.findAll();
        model.addAttribute("countriesInView", countryList);
        return "country-list";
    }

    @GetMapping("/country/add")
    public String showAddForm(Model model) {
        Country newCountry = new Country();
        model.addAttribute("country", newCountry);
        model.addAttribute("continent", continentService.findAll());
        return "country-add";
    }

    @PostMapping("/country/add")
    public String addNewCountry(@Valid Country country, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "country-add";
        }
        countryService.save(country);
        return "redirect:/country/";
    }

    @GetMapping("/country/{id}/delete")
    public String delete(@PathVariable Long id) {
        countryService.delete(id);
        return "redirect:/country/";
    }

}
