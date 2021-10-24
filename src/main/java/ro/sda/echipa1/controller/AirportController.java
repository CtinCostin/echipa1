package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.echipa1.dto.AirportDto;
import ro.sda.echipa1.entities.Airport;
import ro.sda.echipa1.service.AirportService;
import ro.sda.echipa1.service.CityService;


import javax.validation.Valid;
import java.util.List;

@Controller
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private CityService cityService;


    @GetMapping("/airport")
    public String showAirportsPage(Model model) {

        List<Airport> airportList = airportService.findAll();
        model.addAttribute("airportsInView", airportList);

        return "airport-list";
    }

    @GetMapping("/airport/add")
    public String showAddForm(Model model) {
        Airport newAirport = new Airport();
        model.addAttribute("airport", newAirport);
        model.addAttribute("city", cityService.findAll());

        return "airport-add";
    }

    @PostMapping("/airport/add")
    public String addNewAirport(@Valid Airport airport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "airport-add";
        }
        airportService.save(airport);
        return "redirect:/airport";
    }


    @GetMapping("/airport/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {

        model.addAttribute("airport", airportService.findById(id));
        return "airport-edit";
    }

    @PostMapping("/airport/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute AirportDto airportDto) {

        airportService.update(id, airportDto);
        return "redirect:/airport";
    }

    @GetMapping("/airport/{id}/delete")
    public String delete(@PathVariable Long id) {
        airportService.delete(id);
        return "redirect:/airport";
    }


}
