package ro.sda.echipa1.dto;

import lombok.*;
import ro.sda.echipa1.entities.City;
import ro.sda.echipa1.entities.Hotel;
import ro.sda.echipa1.entities.enums.StarRating;
import ro.sda.echipa1.service.CardsCalc;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDto {

    private String name;
    private String description;
    private StarRating starRating;
    private City city;
    private CardsCalc cardsCalc;
    private Hotel hotel;

    public void setCardsCalc(Hotel hotel) {
        this.hotel = hotel;
    }
}
