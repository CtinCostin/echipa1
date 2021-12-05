package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.sda.echipa1.OutOfOffersException;
import ro.sda.echipa1.entities.TourOfferUser;
import ro.sda.echipa1.service.TourOfferCartService;
import ro.sda.echipa1.service.TourOfferUserService;


@Controller
public class TourOfferCartController {

    private TourOfferCartService tourOfferCartService;

    private TourOfferUserService tourOfferUserService;

    @Autowired
    public TourOfferCartController(TourOfferCartService tourOfferCartService, TourOfferUserService tourOfferUserService) {
        this.tourOfferCartService = tourOfferCartService;
        this.tourOfferUserService = tourOfferUserService;
    }


    @GetMapping("/shoppingCart")
    public ModelAndView shoppingCart() {
        ModelAndView modelAndView = new ModelAndView("/cos-cumparaturi");
        modelAndView.addObject("offers", tourOfferCartService.getOffersInCart());
        modelAndView.addObject("total", tourOfferCartService.getTotal());
        return modelAndView;
    }

    @GetMapping("/shoppingCart/addOffer/{offerId}")
    public ModelAndView addOfferToCart(@PathVariable("offerId") Long offerId) {
        TourOfferUser offer = tourOfferUserService.findById(offerId);
        if (offer != null) {
            tourOfferCartService.addOffer(offer);
        }
        return shoppingCart();
    }

    @GetMapping("/shoppingCart/removeOffer/{offerId}")
    public ModelAndView removeOfferFromCart(@PathVariable("offerId") Long offerId) {
        TourOfferUser offer = tourOfferUserService.findById(offerId);
        if (offer != null) {
            tourOfferCartService.removeOffer(offer);
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
