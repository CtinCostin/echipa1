package ro.sda.echipa1.dto;

import lombok.*;
import ro.sda.echipa1.entities.City;
import ro.sda.echipa1.entities.Hotel;
import ro.sda.echipa1.entities.enums.StarRating;

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
    private Hotel hotel;


}
