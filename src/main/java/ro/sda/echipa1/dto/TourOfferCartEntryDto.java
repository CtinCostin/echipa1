package ro.sda.echipa1.dto;

import ro.sda.echipa1.entities.TourOfferUser;

public class TourOfferCartEntryDto {

    private Long id;

    private int quantity;

    private Double price;

    private TourOfferUser tourOfferUser;


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
