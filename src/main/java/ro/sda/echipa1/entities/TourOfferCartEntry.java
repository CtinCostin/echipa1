package ro.sda.echipa1.entities;

import javax.persistence.*;

@Entity
@Table(name = "tour_offer_cart_entries")
public class TourOfferCartEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int quantity;

    private Double price;

    @OneToOne
    private TourOfferUser tourOfferUser;

    public TourOfferCartEntry() {
    }

    public TourOfferCartEntry(int quantity, Double price, TourOfferUser tourOfferUser) {
        this.quantity = quantity;
        this.price = price;
        this.tourOfferUser = tourOfferUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TourOfferUser getTourOfferUser() {
        return tourOfferUser;
    }

    public void setTourOfferUser(TourOfferUser tourOfferUser) {
        this.tourOfferUser = tourOfferUser;
    }
}
