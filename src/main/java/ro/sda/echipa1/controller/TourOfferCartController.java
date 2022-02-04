package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sda.echipa1.OutOfOffersException;
import ro.sda.echipa1.dto.TourOfferAdminDto;
import ro.sda.echipa1.entities.TourOfferAdmin;
import ro.sda.echipa1.service.TourOfferAdminService;
import ro.sda.echipa1.service.TourOfferCartService;
import ro.sda.echipa1.service.TourOfferUserService;


@Controller
public class TourOfferCartController {

    private TourOfferCartService tourOfferCartService;

    private TourOfferAdminService tourOfferAdminService;
    private TourOfferUserService tourOfferUserService;

    @Autowired
    public TourOfferCartController(TourOfferCartService tourOfferCartService, TourOfferAdminService tourOfferAdminService, TourOfferUserService tourOfferUserService) {
        this.tourOfferCartService = tourOfferCartService;
        this.tourOfferAdminService = tourOfferAdminService;
        this.tourOfferUserService = tourOfferUserService;
    }


    @GetMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/shoppingCart");
        TourOfferAdminDto tourOfferAdminDto1 = new TourOfferAdminDto();
        modelAndView.addObject("offers", tourOfferCartService.getOffersInCart());
        modelAndView.addObject("total", tourOfferCartService.getTotal());
        return modelAndView;
    }

    @GetMapping("/shoppingCart/addOffer/{offerId}")
    public ModelAndView addOfferToCart(@PathVariable("offerId") Long offerId,  @RequestParam("price") double price) {
        TourOfferAdmin offer = tourOfferAdminService.findById(offerId);
        if (offer != null) {
            tourOfferCartService.addOffer(offer, price);
        }
        return shoppingCart();
    }

    @GetMapping("/shoppingCart/removeOffer/{offerId}")
    public ModelAndView removeOfferFromCart(@PathVariable("offerId") Long offerId, @RequestParam("price") double price) {
        TourOfferAdmin offer = tourOfferAdminService.findById(offerId);
        if (offer != null) {
            tourOfferCartService.removeOffer(offer, price);
        }
        return shoppingCart();
    }

    @GetMapping("/shoppingCart/checkout")
    public ModelAndView checkout() {
        try {
            tourOfferCartService.checkout();
        } catch (OutOfOffersException exception) {
            return shoppingCart().addObject("outOfOffersMessage", exception.getMessage());
        }
        return shoppingCart();
    }

}