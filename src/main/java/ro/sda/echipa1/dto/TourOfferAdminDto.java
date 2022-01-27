package ro.sda.echipa1.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ro.sda.echipa1.entities.*;
import ro.sda.echipa1.entities.enums.StarRating;
import ro.sda.echipa1.entities.enums.TravelOption;
import ro.sda.echipa1.entities.enums.TypeOfRooms;
import ro.sda.echipa1.entities.enums.TypeOfService;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TourOfferAdminDto {

    private Long id;
    private String name;
    private Continent continent;
    private Country country;
    private City city;
    private TravelOption travelOption;
    private Airport airport;
    private Hotel hotel;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date departureDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfReturn;
    private Integer numberOfDays;
    private TypeOfService typeOfService;
    private TypeOfRooms typeOfRooms;
    private Double priceForAnAdult;
    private Double priceForAChild;
    private Double calculatedPrice;
    private StarRating starRating;
    private int stock;
    private Double price;

    public void setCalculatedPrice(Double calculatedPrice){
        this.calculatedPrice = calculatedPrice;
    }



}


