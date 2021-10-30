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
    private TourOffer tourOffer;

    public TourOfferCartEntry(int quantity, Double price, TourOffer tourOffer) {
        this.quantity = quantity;
        this.price = price;
        this.tourOffer = tourOffer;
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

    public TourOffer getTourOffer() {
        return tourOffer;
    }

    public void setTourOffer(TourOffer tourOffer) {
        this.tourOffer = tourOffer;
    }
}
