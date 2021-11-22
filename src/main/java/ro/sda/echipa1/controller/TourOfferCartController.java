package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.echipa1.dto.TourOfferCartDto;
import ro.sda.echipa1.entities.TourOfferCart;
import ro.sda.echipa1.service.TourOfferCartEntryService;
import ro.sda.echipa1.service.TourOfferCartService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cos-cumparaturi")
public class TourOfferCartController {

    @Autowired
    private TourOfferCartService tourOfferCartService;

    @Autowired
    private TourOfferCartEntryService tourOfferCartEntryService;


    @GetMapping("/")
    public String showTourOfferCartPage(Model model) {

        List<TourOfferCart> tourOfferCarts = tourOfferCartService.getAllTourOffers();
        model.addAttribute("tourOfferCartInView", tourOfferCarts);

        // resolved by the view resolver
        return "tourOfferCart-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        TourOfferCart newTourOfferCart = new TourOfferCart();
        model.addAttribute("tourOfferCart", newTourOfferCart);
        model.addAttribute("tourOfferCartEntries", tourOfferCartEntryService.getAllTourOffersCartEntries());
        model.addAttribute("totalPrice", newTourOfferCart.getTotalPrice());
//        model.addAttribute("user", newTourOfferCart.getUser());
        return "tourOfferCart-add";
    }

    @PostMapping("/add")
    public String addNewTourOfferCart(@Valid TourOfferCart tourOfferCart, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "tourOfferCart-add";
        }
        tourOfferCartService.save(tourOfferCart);
        return "redirect:/tourOfferCart/";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {

        model.addAttribute("tourOfferCart", tourOfferCartService.findById(id));
        return "tourOfferCart-edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute TourOfferCartDto tourOfferCartDto) {

        tourOfferCartService.update(id, tourOfferCartDto);
        return "redirect:/tourOfferCart/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        tourOfferCartService.delete(id);
        return "redirect:/tourOfferCart/";
    }


}
