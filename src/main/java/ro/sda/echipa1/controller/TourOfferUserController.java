package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.echipa1.entities.TourOfferUser;
import ro.sda.echipa1.entities.enums.TravelOption;
import ro.sda.echipa1.entities.enums.TypeOfService;
import ro.sda.echipa1.service.*;
import java.time.LocalDate;
import java.util.List;

@Controller
public class TourOfferUserController {

    @Autowired
    private TourOfferUserService tourOfferUserService;
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
    public String showTourOfferForm(Model model) {

        List<TourOfferUser> tourOfferUserList = tourOfferUserService.findAll();
        model.addAttribute("tourOfferUserInView", tourOfferUserList);
        return "tourOfferUser-list";
    }

    @GetMapping("/results")
    public String showResultsFromSearch(Model model) {
        TourOfferUser tourOfferUser = new TourOfferUser();
        model.addAttribute("tourOfferUser", tourOfferUser);
        model.addAttribute("travelOption", TravelOption.values());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("cities",cityService.findAll());
        model.addAttribute("airports", airportService.findAll());
        model.addAttribute("departureDate", LocalDate.now());
        model.addAttribute("numberOfDays", tourOfferUser.getNumberOfDays());
        model.addAttribute("numberOfRooms", tourOfferUser.getNumberOfRooms());
        model.addAttribute("typeOfService", TypeOfService.values());
        model.addAttribute("numberOfAdult", tourOfferUser.getNumberOfAdult());
        model.addAttribute("numberOfChildren", tourOfferUser.getNumberOfChildren());
        model.addAttribute("price", tourOfferUser.getPrice());
        model.addAttribute("stock", tourOfferUser.getStock());

        return "tourOfferUser-results";
    }

}
