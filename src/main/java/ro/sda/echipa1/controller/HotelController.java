package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ro.sda.echipa1.dto.HotelDto;
import ro.sda.echipa1.entities.Hotel;
import ro.sda.echipa1.entities.StarRating;
import ro.sda.echipa1.service.CityService;
import ro.sda.echipa1.service.HotelService;


import javax.validation.Valid;
import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private CityService cityService;


    @GetMapping("/hotel")
    public String showHotelsPage(Model model) {

        List<Hotel> hotel = hotelService.getAllHotels();
        model.addAttribute("hotelsInView", hotel);
 
        return "hotel-list";
    }

    @GetMapping("/hotel/add")
    public String showAddForm(Model model) {
        Hotel newHotel = new Hotel();
        model.addAttribute("hotel", newHotel);
        model.addAttribute("cities",cityService.findAll());
        model.addAttribute("stars", StarRating.values());
        return "hotel-add";
    }

    @PostMapping("/hotel/add")
    public String addNewHotel(@Valid Hotel hotel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "hotel-add";
        }
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
