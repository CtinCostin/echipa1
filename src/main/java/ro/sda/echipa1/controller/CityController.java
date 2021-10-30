package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.echipa1.entities.City;
import ro.sda.echipa1.service.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private HotelService hotelService;


    @GetMapping("/city")
    public String showCitiesPage(Model model) {

        List<City> cityList = cityService.findAll();
        model.addAttribute("citiesInView", cityList);

        return "city-list";
    }

    @GetMapping("/city/add")
    public String showAddForm(Model model) {
        City newCity = new City();
        model.addAttribute("city", newCity);
        model.addAttribute("country",countryService.findAll());
        model.addAttribute("airports", airportService.findAll());
        model.addAttribute("hotels", hotelService.getAllHotels());

        return "city-add";
    }

    @PostMapping("/city/add")
    public String addNewCity(@Valid City city, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "city-add";
        }
        cityService.save(city);
        return "redirect:/city";
    }

    @GetMapping("/city/{id}/delete")
    public String delete(@PathVariable Long id) {
        cityService.delete(id);
        return "redirect:/city";
    }
}
