package ro.sda.echipa1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ro.sda.echipa1.dto.TourOfferAdminDto;
import ro.sda.echipa1.entities.enums.TravelOption;
import ro.sda.echipa1.entities.enums.TypeOfRooms;
import ro.sda.echipa1.entities.enums.TypeOfService;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tour_offer_admin")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TourOfferAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Continent continent;
    @ManyToOne
    private Country country;
    @ManyToOne
    private City city;
    @Enumerated(EnumType.STRING)
    private TravelOption travelOption;
    @Enumerated(EnumType.STRING)
    private TypeOfRooms typeOfRooms;
    @ManyToOne
    private Airport airport;
    @ManyToOne
    private Hotel hotel;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date departureDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfReturn;
    private Integer numberOfDays;
    @Enumerated(EnumType.STRING)
    private TypeOfService typeOfService;
    private Double priceForAnAdult;
    private Double priceForAChild;





    @Transient
    public TourOfferAdminDto convertToDto(){
        return TourOfferAdminDto.builder()
                .id(id)
                .name(name)
                .continent(continent)
                .country(country)
                .city(city)
                .travelOption(travelOption)
                .airport(airport)
                .hotel(hotel)
                .departureDate(departureDate)
                .dateOfReturn(dateOfReturn)
                .numberOfDays(numberOfDays)
                .typeOfService(typeOfService)
                .typeOfRooms(typeOfRooms)
                .priceForAnAdult(priceForAnAdult)
                .priceForAChild(priceForAChild)
                .calculatedPrice(0.0D).build();
    }
}


