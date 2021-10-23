package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sda.echipa1.dto.HotelDto;
import ro.sda.echipa1.entities.Hotel;
import ro.sda.echipa1.service.CityService;
import ro.sda.echipa1.service.HotelService;


import java.util.List;

@Controller
public class HotelController {


    private HotelService hotelService;
    @Autowired
    private CityService cityService;


    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping("/hotel")
    public String showHotelsPage(Model model) {
        // return a html page with products
        // add list of products
        List<Hotel> hotel = hotelService.findAll();
        model.addAttribute("hotelsInView", hotel);

        // resolved by the view resolver
        return "index";
    }

    @GetMapping("/hotel/add")
    public String showAddFrom(Model model) {
        Hotel newHotel = new Hotel();
        model.addAttribute("hotel", newHotel);
        model.addAttribute("cities",cityService.findAll());
        return "hotel-add";
    }

    @PostMapping("/hotel/add")
    public String addNewHotel(@ModelAttribute Hotel hotel){
        hotelService.save(hotel);
        return "redirect:/hotel";
    }


    @GetMapping("/hotel/{id}/edit")
    public String showEditForm(Model model,
                               @PathVariable Long id) {

        model.addAttribute("hotel", hotelService.findById(id));
        return "hotel-edit";
    }

    @PostMapping("/hotel/{id}/edit")
    public String edit(
            @PathVariable Long id,
            @ModelAttribute HotelDto hotelDto) {

       hotelService.update(id, hotelDto);
        return "redirect:/hotel";
    }

    @GetMapping("/hotel/{id}/delete")
    public String delete(@PathVariable Long id) {
        hotelService.delete(id);
        return "redirect:/hotel";
    }
}
