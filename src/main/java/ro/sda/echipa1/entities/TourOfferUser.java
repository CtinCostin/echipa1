package ro.sda.echipa1.entities;

import org.springframework.format.annotation.DateTimeFormat;
import ro.sda.echipa1.entities.enums.TravelOption;
import ro.sda.echipa1.entities.enums.TypeOfService;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tour_offer_user")
public class TourOfferUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TravelOption travelOption;

    @ManyToOne
    private Country country;
    @ManyToOne
    private City city;
    @ManyToOne
    private Airport airport;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate departureDate;
    private Integer numberOfDays;
    private Integer numberOfRooms;
    @Enumerated(EnumType.STRING)
    private TypeOfService typeOfService;
    private Integer numberOfAdult;
    private Integer numberOfChildren;

    public TourOfferUser() {
    }

    public TourOfferUser(TravelOption travelOption, Country country, City city, Airport airport,
                         LocalDate departureDate, Integer numberOfDays, Integer numberOfRooms,
                         TypeOfService typeOfService, Integer numberOfAdult, Integer numberOfChildren) {
        this.travelOption = travelOption;
        this.country = country;
        this.city = city;
        this.airport = airport;
        this.departureDate = departureDate;
        this.numberOfDays = numberOfDays;
        this.numberOfRooms = numberOfRooms;
        this.typeOfService = typeOfService;
        this.numberOfAdult = numberOfAdult;
        this.numberOfChildren = numberOfChildren;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TravelOption getTravelOption() {
        return travelOption;
    }

    public void setTravelOption(TravelOption travelOption) {
        this.travelOption = travelOption;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(TypeOfService typeOfService) {
        this.typeOfService = typeOfService;
    }

    public Integer getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(Integer numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }
}



