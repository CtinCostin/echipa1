package ro.sda.echipa1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import ro.sda.echipa1.OutOfOffersException;
import ro.sda.echipa1.entities.TourOfferUser;
import ro.sda.echipa1.repository.TourOfferCartRepository;
import ro.sda.echipa1.repository.TourOfferUserRepository;

import java.math.BigDecimal;
import java.util.*;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import ro.sda.echipa1.exception.OutOfOffersException;
//import ro.sda.echipa1.dto.TourOfferAdminDto;
//import ro.sda.echipa1.dto.TourOfferCartDto;
//import ro.sda.echipa1.dto.TourOfferUserDto;
//import ro.sda.echipa1.entities.TourOfferCart;
//import ro.sda.echipa1.entities.TourOfferCartEntry;
//import ro.sda.echipa1.entities.TourOfferUser;
//import ro.sda.echipa1.entities.enums.TourOfferCartStatus;
//import ro.sda.echipa1.repository.TourOfferCartRepository;
//import ro.sda.echipa1.repository.TourOfferUserRepository;
//
//import javax.persistence.NoResultException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;

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
//
//    private TourOfferCartRepository tourOfferCartRepository;
//
//    private List<TourOfferCartEntry> entries = new ArrayList<>();
//
//    private TourOfferUserRepository tourOfferUserRepository;
//
//    private TourOfferUserService tourOfferUserService;
//
//
//    @Autowired
//    public TourOfferCartService(TourOfferCartRepository tourOfferCartRepository,
//                                TourOfferUserRepository tourOfferUserRepository, List<TourOfferCartEntry> entries,
//                                TourOfferUserService tourOfferUserService) {
//        this.tourOfferCartRepository = tourOfferCartRepository;
//        this.tourOfferUserRepository = tourOfferUserRepository;
//        this.entries = entries;
//        this.tourOfferUserService = tourOfferUserService;
//    }
//
//    public TourOfferCart addNewTourOfferCart(TourOfferCart tourOfferCart) {
//        return tourOfferCartRepository.save(tourOfferCart);
//    }
//
//    public List<TourOfferCart> getAllTourOffers() {
//        return tourOfferCartRepository.findAll();
//    }
//
//
//    public TourOfferCart findById(Long id) {
//        return tourOfferCartRepository.findById(id).orElseThrow(
//                () -> new RuntimeException("Tour offer cart not found!"));
//    }
//
//    public void update(Long id, TourOfferCartDto tourOfferCartDto) {
//        tourOfferCartRepository.findById(id)
//                .map(existingTourOfferCart -> updateEntity(tourOfferCartDto, existingTourOfferCart))
//                .map(updatedTourOfferCart -> tourOfferCartRepository.save(updatedTourOfferCart))
//                .orElseThrow(() -> new RuntimeException("Tour offer cart not found !"));
//    }
//
//    private TourOfferCart updateEntity(TourOfferCartDto tourOfferCartDto, TourOfferCart existingTourOfferCart) {
//        existingTourOfferCart.setTourOfferCartEntries(tourOfferCartDto.getTourOfferCartEntries());
//        existingTourOfferCart.setTotalPrice(tourOfferCartDto.getTotalPrice());
////        existingTourOfferCart.setUser(tourOfferCartDto.getUser());
//
//        return existingTourOfferCart;
//    }
//
//    @Transactional
//    public void delete(Long id) {
//        tourOfferCartRepository.deleteById(id);
//    }
//
//    public void save(TourOfferCart tourOfferCart) {
//        tourOfferCartRepository.save(tourOfferCart);
//    }
//
//    public void addToCart(Long id, TourOfferCartDto tourOfferCartDto) {
//        TourOfferCart tourOfferCart = new TourOfferCart();
//        try {
//            tourOfferCart = tourOfferCartDto.getCurrentCart(tourOfferCart);
//
//        } catch (NoResultException noResultException) {
//            tourOfferCart = new TourOfferCart();
//            tourOfferCart.setTourOfferCartStatus(TourOfferCartStatus.IN_PROGRESS);
//
//        }
//        tourOfferCart = new TourOfferCart();
//        entries = tourOfferCart.getTourOfferCartEntries();
//        boolean isAlreadyInCart = false;
//        for (TourOfferCartEntry tourOfferCartEntry : entries) {
//            TourOfferUser tourOfferUser = tourOfferCartEntry.getTourOfferUser();
//            if (tourOfferUser.getId() == id) {
//                isAlreadyInCart = true;
//                tourOfferCartEntry.setQuantity(tourOfferCartEntry.getQuantity() + 1);
//                tourOfferCartEntry.setPrice(tourOfferCartEntry.getQuantity() * tourOfferCartEntry.getPrice());
//            }
//        }
//        Optional<TourOfferUser> tourOfferUser = tourOfferUserRepository.findById(id);
//        if (!isAlreadyInCart) {
//            TourOfferCartEntry newTourOfferCartEntry = new TourOfferCartEntry();
//            newTourOfferCartEntry.setPrice(tourOfferUser.get().getPrice());
//            newTourOfferCartEntry.setQuantity(1);
//            newTourOfferCartEntry.setTourOfferUser(tourOfferUser.get());
//            entries.add(newTourOfferCartEntry);
//        }
//        if (tourOfferUser.get().getStock() <= 0) {
//            throw new OutOfOffersException();
//        }
//        tourOfferUser.get().setStock(tourOfferUser.get().getStock() - 1);
//        tourOfferUserService.update(id, tourOfferUser.get());
//
//        List<TourOfferCartEntry> entries = tourOfferCart.getTourOfferCartEntries();
//        double sum = 0;
//        for (TourOfferCartEntry entry : entries) {
//            sum = sum + entry.getPrice();
//        }
//        tourOfferCart.setTotalPrice(sum);
//        tourOfferCartRepository.save(tourOfferCart);
//
//    }
//
//    public void finalizeCurrentOrder(Long id) {
//        TourOfferCart tourOfferCart = tourOfferCartRepository.getById(id);
//        tourOfferCart.setTourOfferCartStatus(TourOfferCartStatus.COMPLETED);
//        tourOfferCartRepository.save(tourOfferCart);
//    }
//
//    public Double calculatePrice(Long id, TourOfferUserDto tourOfferUserDto, TourOfferAdminDto tourOfferAdminDto) {
//        Optional<TourOfferUser> tourOfferUserOptional = tourOfferUserRepository.findById(id);
//        Integer numberOfAdults = tourOfferUserDto.getNumberOfAdult();
//        Integer numberOfChildren = tourOfferUserDto.getNumberOfChildren();
//        Double price = numberOfAdults * tourOfferAdminDto.getPriceForAnAdult() + numberOfChildren *
//                tourOfferAdminDto.getPriceForAChild();
//        tourOfferUserOptional.get().setPrice(price);
//
//        return price;
//
//
//    }
//
//}
