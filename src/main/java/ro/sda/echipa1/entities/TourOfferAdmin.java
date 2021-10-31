package ro.sda.echipa1.entities;

import org.springframework.format.annotation.DateTimeFormat;
import ro.sda.echipa1.entities.enums.TravelOption;
import ro.sda.echipa1.entities.enums.TypeOfService;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tour_offer_admin")
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
    @ManyToOne
    private Airport airport;
    @ManyToOne
    private Hotel hotel;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate departureDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfReturn;
    private Integer numberOfDays;
    @Enumerated(EnumType.STRING)
    private TypeOfService typeOfService;
    private Double priceForAnAdult;
    private Double priceForAChild;
    private Integer numberOfAdult;
    private Integer numberOfPLacesForChildren;

    public TourOfferAdmin() {
    }

    public TourOfferAdmin(Long id, String name, Continent continent, Country country, City city,
                          TravelOption travelOption, Airport airport, Hotel hotel, LocalDate departureDate,
                          LocalDate dateOfReturn, Integer numberOfDays, TypeOfService typeOfService,
                          Double priceForAnAdult, Double priceForAChild, Integer numberOfAdult,
                          Integer numberOfPLacesForChildren) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.country = country;
        this.city = city;
        this.travelOption = travelOption;
        this.airport = airport;
        this.hotel = hotel;
        this.departureDate = departureDate;
        this.dateOfReturn = dateOfReturn;
        this.numberOfDays = numberOfDays;
        this.typeOfService = typeOfService;
        this.priceForAnAdult = priceForAnAdult;
        this.priceForAChild = priceForAChild;
        this.numberOfAdult = numberOfAdult;
        this.numberOfPLacesForChildren = numberOfPLacesForChildren;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(TypeOfService typeOfService) {
        this.typeOfService = typeOfService;
    }

    public Double getPriceForAnAdult() {
        return priceForAnAdult;
    }

    public void setPriceForAnAdult(Double priceForAnAdult) {
        this.priceForAnAdult = priceForAnAdult;
    }

    public Double getPriceForAChild() {
        return priceForAChild;
    }

    public void setPriceForAChild(Double priceForAChild) {
        this.priceForAChild = priceForAChild;
    }

    public Integer getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(Integer numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public Integer getNumberOfPLacesForChildren() {
        return numberOfPLacesForChildren;
    }

    public void setNumberOfPLacesForChildren(Integer numberOfPLacesForChildren) {
        this.numberOfPLacesForChildren = numberOfPLacesForChildren;
    }

    public TravelOption getTravelOption() {
        return travelOption;
    }

    public void setTravelOption(TravelOption travelOption) {
        this.travelOption = travelOption;
    }
}


