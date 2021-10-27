package ro.sda.echipa1.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=1, max=100, message = "Please use minimum 50 character and maximum 4000 for name")
    private String name;

    @ManyToOne
    private Continent continent;

    @OneToMany(mappedBy = "country",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<City> cityList = new ArrayList<>();

    public Country() {
    }

    public Country(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
    }

    public Country(List<City> cityList) {
        this.cityList = cityList;
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

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
