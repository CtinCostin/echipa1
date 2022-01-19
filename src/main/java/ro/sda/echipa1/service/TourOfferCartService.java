package ro.sda.echipa1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.echipa1.OutOfOffersException;
import ro.sda.echipa1.entities.TourOfferUser;
import ro.sda.echipa1.repository.TourOfferCartRepository;
import ro.sda.echipa1.repository.TourOfferUserRepository;

import java.math.BigDecimal;
import java.util.*;

@Service
public class TourOfferCartService {

    private TourOfferUserRepository tourOfferUserRepository;

    private TourOfferCartRepository tourOfferCartRepository;

    private Map<TourOfferUser, Integer> offers = new HashMap<>();

    @Autowired
    public TourOfferCartService(TourOfferUserRepository tourOfferUserRepository, TourOfferCartRepository tourOfferCartRepository) {
        this.tourOfferUserRepository = tourOfferUserRepository;
        this.tourOfferCartRepository = tourOfferCartRepository;
    }

    //    If tourOfferUser is in the map just increment quantity by 1.
//    If tourOfferUser is not in the map with, add it with quantity 1

    public void addOffer(TourOfferUser tourOfferUser) {
        if (offers.containsKey(tourOfferUser)) {
            offers.replace(tourOfferUser, offers.get(tourOfferUser) + 1);
        } else {
            offers.put(tourOfferUser, 1);
        }
    }

    //    If tourOfferUser is in the map with quantity > 1, just decrement quantity by 1.
//    If tourOfferUser is in the map with quantity 1, remove it from map

    public void removeOffer(TourOfferUser tourOfferUser) {
        if (offers.containsKey(tourOfferUser)) {
            if (offers.get(tourOfferUser) > 1)
                offers.replace(tourOfferUser, offers.get(tourOfferUser) - 1);
            else if (offers.get(tourOfferUser) == 1) {
                offers.remove(tourOfferUser);
            }
        }
    }

    //  @return unmodifiable copy of the map

    public Map<TourOfferUser, Integer> getOffersInCart() {
        return Collections.unmodifiableMap(offers);
    }

//    Checkout will rollback if there is not enough of some offers in stock
//    @throws OutOfOffersException

    public void checkout() throws OutOfOffersException {
        TourOfferUser tourOfferUser;
        for (Map.Entry<TourOfferUser, Integer> entry : offers.entrySet()) {
            Long tourOfferUserKey = entry.getKey().getId();
            // Refresh quantity for every product before checking
            tourOfferUser = tourOfferUserRepository.findById(tourOfferUserKey).orElseThrow();
            if (tourOfferUser.getStock() < entry.getValue())
                throw new OutOfOffersException();
            entry.getKey().setStock(tourOfferUser.getStock() - entry.getValue());
            tourOfferUserRepository.save(entry.getKey());
        }
        tourOfferUserRepository.flush();
        offers.clear();
    }

    public double getTotal() {
        return offers.entrySet().stream()
                .map(entry -> BigDecimal.valueOf(entry.getKey().getPrice() * entry.getValue()))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO).doubleValue();
    }

}
