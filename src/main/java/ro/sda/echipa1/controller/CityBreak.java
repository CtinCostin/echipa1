package ro.sda.echipa1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sda.echipa1.service.HotelService;

@Controller
public class CityBreak {

    @Autowired
    private HotelService hotelService;


}
