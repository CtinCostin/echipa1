package ro.sda.echipa1.dto;

import ro.sda.echipa1.entities.City;
import ro.sda.echipa1.entities.Continent;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDto {


    private Long id;

    private String name;

    private Continent continent;

    private List<City> cityList = new ArrayList<>();

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

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
