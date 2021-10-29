package ro.sda.echipa1.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "continent")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=1, max=100,message = "Please use minimum 1 character and maximum 100 for name")
    private String name;

    @OneToMany(mappedBy = "continent",
            cascade = CascadeType.ALL)
    private List<Country> countryList = new ArrayList<>();

    @OneToMany(mappedBy = "continent",
            cascade = CascadeType.ALL)
    private  List<TourOffer> tourOffer = new ArrayList<>();

    public Continent() {
    }

    public Continent(String name, List<Country> countryList, List<TourOffer> tourOffer){
        this.name = name;
        this.countryList = countryList;
        this.tourOffer = tourOffer;
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

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<TourOffer> getTourOffer() {
        return tourOffer;
    }

    public void setTourOffer(List<TourOffer> tourOffer) {
        this.tourOffer = tourOffer;
    }
}


