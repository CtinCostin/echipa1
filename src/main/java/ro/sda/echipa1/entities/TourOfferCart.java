package ro.sda.echipa1.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tour_offer_cart")
public class TourOfferCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<TourOfferCartEntry> tourOfferCartEntries = new ArrayList<>();

    private Double totalPrice;

    @OneToOne
    private User user;


    public TourOfferCart() {

    }

    public TourOfferCart(List<TourOfferCartEntry> tourOfferCartEntries, Double totalPrice, User user) {
        this.tourOfferCartEntries = tourOfferCartEntries;
        this.totalPrice = totalPrice;
        this.user = user;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TourOfferCartEntry> getTourOfferCartEntries() {
        return tourOfferCartEntries;
    }

    public void setTourOfferCartEntries(List<TourOfferCartEntry> tourOfferCartEntries) {
        this.tourOfferCartEntries = tourOfferCartEntries;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
