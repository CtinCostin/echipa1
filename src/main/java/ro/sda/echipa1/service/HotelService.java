package ro.sda.echipa1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.echipa1.entities.Hotel;
import ro.sda.echipa1.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel addNewHotel(Hotel hotel){
        return hotelRepository.save(hotel);
    }


}
