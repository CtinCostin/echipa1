package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.echipa1.dto.TourOfferAdminDto;
import ro.sda.echipa1.dto.TourOfferUserDto;
import ro.sda.echipa1.entities.Hotel;
import ro.sda.echipa1.entities.TourOfferAdmin;
import ro.sda.echipa1.entities.TourOfferUser;
import ro.sda.echipa1.entities.enums.TravelOption;
import ro.sda.echipa1.entities.enums.TypeOfService;
import ro.sda.echipa1.service.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TourOfferUserController {

    @Autowired
    private TourOfferUserService tourOfferUserService;
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


    @RequestMapping("/")
    public String showTourOfferForm(Model model) {
        List<TourOfferUser> tourOfferUserList = tourOfferUserService.findAll();
        model.addAttribute("formObject",new TourOfferUserDto());
        model.addAttribute("tourOfferUserInView", tourOfferUserList);
        model.addAttribute("travelOption", TravelOption.values());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("cities",cityService.findAll());
        model.addAttribute("airports", airportService.findAll());
        model.addAttribute("departureDate", LocalDate.now());
        model.addAttribute("typeOfService", TypeOfService.values());

        return "user-select-tour-offer";
    }

    @PostMapping("/searchOffer")
    public String showResultsFromSearch(TourOfferUserDto formObject, Model model) {
        TourOfferUserDto searchCriteria= formObject;
        List<TourOfferAdmin> allOffers=tourOfferAdminService.findAll();
        if (searchCriteria.getCountry() != null){
            allOffers = allOffers.stream().filter(ofer -> ofer.getCity().getCountry().equals(searchCriteria.getCountry())).collect(Collectors.toList());
        }
        if (searchCriteria.getCity()!= null){
            allOffers = allOffers.stream().filter(ofer -> ofer.getCity().equals(searchCriteria.getCity())).collect(Collectors.toList());
        }
//        if (searchCriteria.getPrice() != null){
//            Double price = tourOfferUserService.calculatePrice();
//            allOffers = allOffers.stream().filter(ofer -> ofer.getPriceForAnAdult().equals(searchCriteria.getPrice())).collect(Collectors.toList());
//        }


        model.addAttribute("resultObject",allOffers);

        return "tourOfferUser-results";
    }

}