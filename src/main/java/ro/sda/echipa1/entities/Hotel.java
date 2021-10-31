package ro.sda.echipa1.entities;

import ro.sda.echipa1.entities.enums.StarRating;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1, max=7000,message = "Please use minimum 1 character and maximum 4000 for name")
    private String name;

    @Enumerated(EnumType.STRING)
    private StarRating starRating;

    @NotNull
    @Size(min=1, max=7000,message = "Please use minimum 1 character and maximum 4000 name")
    private String description;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "hotel",
            cascade = CascadeType.ALL)
    private List<TourOfferAdmin> tourOfferAdmin = new ArrayList<>();

    public Hotel() {

    }

    public Hotel(String description, String name, StarRating starRating, City city){
        this.description = description;
        this.name = name;
        this.starRating = starRating;
        this.city = city;
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

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


}
