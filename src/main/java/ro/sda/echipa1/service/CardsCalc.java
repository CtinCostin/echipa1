package ro.sda.echipa1.service;

import org.springframework.stereotype.Service;
import ro.sda.echipa1.OutOfOffersException;
import ro.sda.echipa1.entities.Hotel;

@Service
public class CardsCalc {
    public Hotel calculateCards(CardsParam cardsParam) {
        Hotel result = null;
        result = cardsParam.getHotel();

        if (cardsParam.getHotel() != null) {
            throw new OutOfOffersException();
        }

        return result;


    }


}
