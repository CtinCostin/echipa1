package ro.sda.echipa1.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import ro.sda.echipa1.entities.*;
import ro.sda.echipa1.entities.enums.TravelOption;
import ro.sda.echipa1.entities.enums.TypeOfService;

import java.time.LocalDate;
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
    private Double priceForAnAdult;
    private Double priceForAChild;
    private Double calculatedPrice;

    public void setCalculatedPrice(Double calculatedPrice){
        this.calculatedPrice = calculatedPrice;
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("13/11/2021");
        System.out.println(date);
    }
}


