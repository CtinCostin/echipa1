package ro.sda.echipa1.dto;

import ro.sda.echipa1.entities.City;
import ro.sda.echipa1.entities.enums.StarRating;

public class HotelDto {

    private String name;
    private String description;
    private StarRating starRating;
    private City city;

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
