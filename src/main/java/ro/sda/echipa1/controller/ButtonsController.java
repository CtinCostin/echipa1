package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.echipa1.entities.TourOfferAdmin;
import ro.sda.echipa1.service.TourOfferAdminService;

import java.util.List;

@Controller
public class ButtonsController {

    @Autowired
    private TourOfferAdminService tourOfferAdminService;


    @GetMapping("/cazare-Romania")
    public String showOffersRomania(Model model) {

        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.findAll();
        model.addAttribute("tourOfferInView", tourOfferAdminList);

        return "cazare-Romania";
    }

    @GetMapping("/city-break")
    public String showCityBreak(Model model) {

        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.findAll();
        model.addAttribute("tourOfferInView", tourOfferAdminList);

        return "city-break";
    }

    @GetMapping("/promotii")
    public String showPromoted(Model model) {

        List<TourOfferAdmin> tourOfferAdminList = tourOfferAdminService.findAll();
        model.addAttribute("tourOfferInView", tourOfferAdminList);

        return "promotii";
    }

    @GetMapping("/contact")
    public String showContact() {

        return "contact";
    }

    @GetMapping("/despre_noi")
    public String showAboutPage(Model model) {

        return "despre_noi";
    }

    @GetMapping("/termeni_si_conditii")
    public String showTermsPage(Model model) {

        return "termeni_si_conditii";
    }





}
