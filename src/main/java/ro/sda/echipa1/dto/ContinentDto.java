package ro.sda.echipa1.dto;

import ro.sda.echipa1.entities.Country;
import java.util.ArrayList;
import java.util.List;

public class ContinentDto {

    private Long id;

    private String name;

    private List<Country> countryList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
}
