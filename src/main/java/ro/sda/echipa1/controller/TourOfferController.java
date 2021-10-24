package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.echipa1.dto.TourOfferDto;
import ro.sda.echipa1.entities.TourOffer;
import ro.sda.echipa1.entities.TypeOfService;
import ro.sda.echipa1.service.AirportService;
import ro.sda.echipa1.service.CityService;
import ro.sda.echipa1.service.HotelService;
import ro.sda.echipa1.service.TourOfferService;


import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TourOfferController {

    @Autowired
    private TourOfferService tourOfferService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private CityService cityService;
    @Autowired
    private AirportService airportService;


    @GetMapping("/tourOffer")
    public String showToursOfferPage(Model model) {

        List<TourOffer> tourOfferList = tourOfferService.findAll();
        model.addAttribute("tourOfferInView", tourOfferList);

        // resolved by the view resolver
        return "tour-list";
    }

    @GetMapping("/tourOffer/add")
    public String showAddForm(Model model) {
        TourOffer newTourOffer = new TourOffer();
        model.addAttribute("tourOffer", newTourOffer);
        model.addAttribute("cities",cityService.findAll());
        model.addAttribute("hotels", hotelService.findAll());
        model.addAttribute("airports", airportService.findAll());
        model.addAttribute("departureDate", LocalDate.now());
        model.addAttribute("dateOfReturn", LocalDate.now());
        model.addAttribute("typeOfService", TypeOfService.values());
        return "tourOffer-add";
    }

    @PostMapping("/tourOffer/add")
    public String addNewTourOffer(@Valid TourOffer tourOffer, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "tourOffer-add";
        }
        tourOfferService.save(tourOffer);
        return "redirect:/tourOffer";
    }


    @GetMapping("/tourOffer/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {

        model.addAttribute("tourOffer", tourOfferService.findById(id));
        return "tourOffer-edit";
    }

    @PostMapping("/tourOffer/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute TourOfferDto tourOfferDto) {

        tourOfferService.update(id, tourOfferDto);
        return "redirect:/tourOffer";
    }

    @GetMapping("/tourOffer/{id}/delete")
    public String delete(@PathVariable Long id) {
        tourOfferService.delete(id);
        return "redirect:/tourOffer";
    }
}
