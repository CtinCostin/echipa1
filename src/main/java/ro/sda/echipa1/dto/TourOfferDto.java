package ro.sda.echipa1.dto;

import ro.sda.echipa1.entities.Airport;
import ro.sda.echipa1.entities.City;
import ro.sda.echipa1.entities.Hotel;
import ro.sda.echipa1.entities.TypeOfService;

import java.time.LocalDate;


public class TourOfferDto {

    private Long id;
    private String name;
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

    public TourOfferDto() {
    }

    public TourOfferDto(String name, City city, Airport airport, Hotel hotel, LocalDate departureDate, LocalDate dateOfReturn,
                        Integer numberOfDays, TypeOfService typeOfService, Double priceForAnAdult,
                        Double priceForAChild, Boolean promoted, Integer numberOfAdult, Integer numberOfPLacesForChildren) {
        this.name = name;
        this.city = city;
        this.airport = airport;
        this.hotel = hotel;
        this.departureDate = departureDate;
        this.dateOfReturn = dateOfReturn;
        this.numberOfDays = numberOfDays;
        this.typeOfService = typeOfService;
        this.priceForAnAdult = priceForAnAdult;
        this.priceForAChild = priceForAChild;
        this.promoted = promoted;
        this.numberOfAdult = numberOfAdult;
        this.numberOfPLacesForChildren = numberOfPLacesForChildren;
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


