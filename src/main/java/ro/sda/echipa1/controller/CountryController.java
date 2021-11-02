package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.echipa1.dto.CountryDto;
import ro.sda.echipa1.dto.HotelDto;
import ro.sda.echipa1.entities.Country;
import ro.sda.echipa1.service.CityService;
import ro.sda.echipa1.service.ContinentService;
import ro.sda.echipa1.service.CountryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private ContinentService continentService;
//    @Autowired
//    private CityService cityService;


    @GetMapping("/")
    public String showCountriesPage(Model model) {
        List<Country> country = countryService.findAll();
        model.addAttribute("countriesInView", country);
        return "country-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Country newCountry = new Country();
        model.addAttribute("country", newCountry);
        model.addAttribute("continents", continentService.findAll());
        return "country-add";
    }

    @PostMapping("/add")
    public String addNewCountry(@Valid Country country, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "country-add";
        }
        countryService.save(country);
        return "redirect:/country/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {

        model.addAttribute("country", countryService.findById(id));
        return "country-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute CountryDto countryDto) {

        countryService.update(id, countryDto);
        return "redirect:/country/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        countryService.delete(id);
        return "redirect:/country/";
    }

}
