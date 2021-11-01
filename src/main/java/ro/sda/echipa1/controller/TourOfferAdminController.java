package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.echipa1.dto.TourOfferAdminDto;
import ro.sda.echipa1.entities.TourOfferAdmin;
import ro.sda.echipa1.entities.enums.TravelOption;
import ro.sda.echipa1.entities.enums.TypeOfService;
import ro.sda.echipa1.service.*;


import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/tourOfferAdmin")
public class TourOfferAdminController {

    @Autowired
    private TourOfferAdminService tourOfferAdminService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private CityService cityService;
    @Autowired
    private AirportService airportService;
    @Autowired
    private ContinentService continentService;
    @Autowired
    private CountryService countryService;


    @GetMapping("/")
    public String showToursOfferPage(Model model) {

        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.findAll();
        model.addAttribute("tourOfferInView", tourOfferAdminList);
        return "tourOfferAdmin-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        TourOfferAdmin newTourOfferAdmin = new TourOfferAdmin();
        model.addAttribute("tourOfferAdmin", newTourOfferAdmin);
        model.addAttribute("continents", continentService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("cities",cityService.findAll());
        model.addAttribute("travelOption", TravelOption.values());
        model.addAttribute("hotels", hotelService.getAllHotels());
        model.addAttribute("airports", airportService.findAll());
        model.addAttribute("departureDate", LocalDate.now());
        model.addAttribute("dateOfReturn", LocalDate.now());
        model.addAttribute("numberOfDays", newTourOfferAdmin.getNumberOfDays());
        model.addAttribute("priceForAnAdult", newTourOfferAdmin.getPriceForAnAdult());
        model.addAttribute("priceForAChild", newTourOfferAdmin.getPriceForAChild());
        model.addAttribute("numberOfPlacesForChildren", newTourOfferAdmin.getNumberOfPLacesForChildren());
        model.addAttribute("typeOfService", TypeOfService.values());
        return "tourOfferAdmin-add";
    }

    @PostMapping("/add")
    public String addNewTourOffer(@ModelAttribute("tourOfferAdmin") @Valid TourOfferAdmin tourOfferAdmin, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "tourOfferAdmin-add";
        }
        tourOfferAdminService.save(tourOfferAdmin);
        return "redirect:/tourOfferAdmin/";
    }


    @GetMapping("/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {

        model.addAttribute("tourOfferAdmin", tourOfferAdminService.findById(id));
        model.addAttribute("continents", continentService.findAll());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("cities",cityService.findAll());
        model.addAttribute("travelOption", TravelOption.values());
        model.addAttribute("hotels", hotelService.getAllHotels());
        model.addAttribute("airports", airportService.findAll());
        model.addAttribute("departureDate", LocalDate.now());
        model.addAttribute("dateOfReturn", LocalDate.now());
        model.addAttribute("numberOfDays", tourOfferAdminService.findById(id).getNumberOfDays());
        model.addAttribute("priceForAnAdult", tourOfferAdminService.findById(id).getPriceForAnAdult());
        model.addAttribute("priceForAChild", tourOfferAdminService.findById(id).getPriceForAChild());
        model.addAttribute("numberOfPlacesForChildren", tourOfferAdminService.findById(id).getNumberOfPLacesForChildren());
        model.addAttribute("typeOfService", TypeOfService.values());

        return "tourOfferAdmin-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute TourOfferAdminDto tourOfferAdminDto) {

        tourOfferAdminService.update(id, tourOfferAdminDto);
        return "redirect:/tourOfferAdmin/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        tourOfferAdminService.delete(id);
        return "redirect:/tourOfferAdmin/";
    }
}
