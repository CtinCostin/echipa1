package ro.sda.echipa1.dto;

import ro.sda.echipa1.entities.*;
import ro.sda.echipa1.entities.enums.TypeOfService;

import java.time.LocalDate;


public class TourOfferAdminDto {

    private Long id;
    private String name;
    private Continent continent;
    private Country country;
    private City city;
    private Airport airport;
    private Hotel hotel;
    private LocalDate departureDate;
    private LocalDate dateOfReturn;
    private Integer numberOfDays;
    private TypeOfService typeOfService;
    private Double priceForAnAdult;
    private Double priceForAChild;
    private Boolean promoted;
    private Integer numberOfAdult;
    private Integer numberOfPLacesForChildren;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getPromoted() {
        return promoted;
    }

    public void setPromoted(Boolean promoted) {
        this.promoted = promoted;
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
}


