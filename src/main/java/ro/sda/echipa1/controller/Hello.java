package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ro.sda.echipa1.entities.TourOfferAdmin;
import ro.sda.echipa1.entities.enums.TravelOption;
import ro.sda.echipa1.entities.enums.TypeOfService;
import ro.sda.echipa1.service.TourOfferAdminService;

import java.time.LocalDate;

@Controller
public class Hello {

    @Autowired
    private TourOfferAdminService tourOfferAdminService;


    @GetMapping("/test")
    public String testMethod(){
        return "redirect:/user-select-tour-offer";
    }

    @PostMapping("/user-select-tour-offer")
    public String showAddForm(Model model) {
        TourOfferAdmin newTourOfferAdmin = new TourOfferAdmin();
        model.addAttribute("travelOption", TravelOption.values());
        return "user-select-tour-offer";
    }

}


