package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.echipa1.entities.TourOfferAdmin;
import ro.sda.echipa1.service.HotelService;
import ro.sda.echipa1.service.TourOfferAdminService;

import java.util.List;

@Controller
public class CazareRomania {

    @Autowired
    private TourOfferAdminService tourOfferAdminService;


    @GetMapping("/cazare-Romania")
    public String showToursOfferPage(Model model) {

        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.findAll();
        model.addAttribute("tourOfferInView", tourOfferAdminList);

        return "cazare-Romania";
    }

    @GetMapping("/despre_noi")
    public String showAboutUsPage(Model model) {

        return "despre_noi";
    }

    @GetMapping("/termeni_si_conditii")
    public String showTerms(Model model) {

        return "termeni_si_conditii";
    }
}

//    @GetMapping("/add")
//    public String showAddForm(Model model) {
//        Hello hello = new Hello();
//        model.addAttribute("countries", countryService.findAll());
//        model.addAttribute("departureDate", LocalDate.now());
//        model.addAttribute("dateOfReturn", LocalDate.now());
//    return hello.testMethod();
//    }

