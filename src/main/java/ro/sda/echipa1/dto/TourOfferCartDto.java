package ro.sda.echipa1.dto;

import ro.sda.echipa1.entities.TourOfferCartEntry;
import ro.sda.echipa1.entities.User;
import java.util.ArrayList;
import java.util.List;

public class TourOfferCartDto {

    private Long id;

    private List<TourOfferCartEntry> tourOfferCartEntries = new ArrayList<>();

    private Double totalPrice;

    private User user;


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
