package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.echipa1.dto.CityDto;
import ro.sda.echipa1.dto.HotelDto;
import ro.sda.echipa1.entities.City;
import ro.sda.echipa1.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private HotelService hotelService;


    @GetMapping("/")
    public String showCitiesPage(Model model) {

        List<City> cityList = cityService.findAll();
        model.addAttribute("citiesInView", cityList);

        return "city-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        City newCity = new City();
        model.addAttribute("city", newCity);
        model.addAttribute("countries",countryService.findAll());

        return "city-add";
    }

    @PostMapping("/add")
    public String addNewCity(@ModelAttribute("city") @Valid City city, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "city-add";
        }
        cityService.save(city);
        return "redirect:/city/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {

        model.addAttribute("city", cityService.findById(id));
        model.addAttribute("countries",countryService.findAll());
        return "city-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute CityDto cityDto) {

        cityService.update(id, cityDto);
        return "redirect:/city/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        cityService.delete(id);
        return "redirect:/city/";
    }
}
