package ro.sda.echipa1.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.sda.echipa1.entities.TourOfferCart;
import ro.sda.echipa1.entities.TourOfferCartEntry;
import ro.sda.echipa1.repository.TourOfferCartRepository;

import java.util.ArrayList;
import java.util.List;

public class TourOfferCartDto {

    private static final Logger log = LoggerFactory.getLogger(TourOfferCartDto.class);

    private Long id;

    private List<TourOfferCartEntry> tourOfferCartEntries = new ArrayList<>();

    private Double totalPrice;

//    private User user;
    private TourOfferCartRepository tourOfferCartRepository;


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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public TourOfferCart getCurrentCart(TourOfferCart tourOfferCart) {

        return tourOfferCartRepository.findById(id).
                filter(existingTourOfferCart -> existingTourOfferCart.getId().
                        equals(tourOfferCart.getId())).
                map(existingTourOfferCart -> tourOfferCartRepository.save(tourOfferCart)).
                orElseThrow(() -> {
                    log.error("Offer already exists!");
                    throw new RuntimeException("Offer already exists!");
                });
    }
}
