package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.sda.echipa1.entities.Hotel;
import ro.sda.echipa1.service.HotelService;

import javax.validation.Valid;

@Controller
@RequestMapping("/hotel")
public class HotelController {


    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }


    @GetMapping("/add")
    public String showAddFrom(Model model) {
        Hotel newHotel = new Hotel();
        model.addAttribute("hotel", newHotel);
        return "hotel-add";
    }

    @PostMapping("/add")
    public String addNewHotel(@ModelAttribute Hotel hotel){
        hotelService.addNewHotel(hotel);
        return "redirect:/hotel";
    }
}
