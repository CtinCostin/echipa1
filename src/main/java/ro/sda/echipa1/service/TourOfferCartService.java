package ro.sda.echipa1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa1.OutOfOffersException;
import ro.sda.echipa1.dto.TourOfferCartDto;
import ro.sda.echipa1.entities.TourOfferAdmin;
import ro.sda.echipa1.entities.TourOfferCart;
import ro.sda.echipa1.entities.TourOfferCartEntry;
import ro.sda.echipa1.entities.TourOfferUser;
import ro.sda.echipa1.entities.enums.TourOfferCartStatus;
import ro.sda.echipa1.repository.TourOfferCartRepository;
import ro.sda.echipa1.repository.TourOfferUserRepository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TourOfferCartService {

    private TourOfferCartRepository tourOfferCartRepository;

    private TourOfferCartDto tourOfferCartDto;

    private List<TourOfferCartEntry> entries = new ArrayList<>();

    private TourOfferUserRepository tourOfferUserRepository;

    private TourOfferUser tourOfferUser;

    private TourOfferUserService tourOfferUserService;

    private TourOfferAdmin tourOfferAdmin;

    @Autowired
    public TourOfferCartService(TourOfferCartRepository tourOfferCartRepository,
                                TourOfferUserRepository tourOfferUserRepository, List<TourOfferCartEntry> entries,
                                TourOfferUserService tourOfferUserService) {
        this.tourOfferCartRepository = tourOfferCartRepository;
        this.tourOfferUserRepository = tourOfferUserRepository;
        this.entries = entries;
        this.tourOfferUserService = tourOfferUserService;
    }

    public TourOfferCart addNewTourOfferCart(TourOfferCart tourOfferCart) {
        return tourOfferCartRepository.save(tourOfferCart);
    }

    public List<TourOfferCart> getAllTourOffers() {
        return tourOfferCartRepository.findAll();
    }


    public TourOfferCart findById(Long id) {
        return tourOfferCartRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tour offer cart not found!"));
    }

    public void update(Long id, TourOfferCartDto tourOfferCartDto) {
        tourOfferCartRepository.findById(id)
                .map(existingTourOfferCart -> updateEntity(tourOfferCartDto, existingTourOfferCart))
                .map(updatedTourOfferCart -> tourOfferCartRepository.save(updatedTourOfferCart))
                .orElseThrow(() -> new RuntimeException("Tour offer cart not found !"));
    }

    private TourOfferCart updateEntity(TourOfferCartDto tourOfferCartDto, TourOfferCart existingTourOfferCart) {
        existingTourOfferCart.setTourOfferCartEntries(tourOfferCartDto.getTourOfferCartEntries());
        existingTourOfferCart.setTotalPrice(tourOfferCartDto.getTotalPrice());
        existingTourOfferCart.setUser(tourOfferCartDto.getUser());

        return existingTourOfferCart;
    }

    @Transactional
    public void delete(Long id) {
        tourOfferCartRepository.deleteById(id);
    }

    public void save(TourOfferCart tourOfferCart) {
        tourOfferCartRepository.save(tourOfferCart);
    }

    public void addToCart(Long id) {
        TourOfferCart tourOfferCart = new TourOfferCart();
        try {
            tourOfferCart = tourOfferCartDto.getCurrentCart(tourOfferCart);

        } catch (NoResultException noResultException) {
            tourOfferCart = new TourOfferCart();
            tourOfferCart.setTourOfferCartStatus(TourOfferCartStatus.IN_PROGRESS);

        }
        tourOfferCart = new TourOfferCart();
        entries = tourOfferCart.getTourOfferCartEntries();
        boolean isAlreadyInCart = false;
        for (TourOfferCartEntry tourOfferCartEntry : entries) {
            TourOfferUser tourOfferUser = tourOfferCartEntry.getTourOfferUser();
            if (tourOfferUser.getId() == id) {
                isAlreadyInCart = true;
                tourOfferCartEntry.setQuantity(tourOfferCartEntry.getQuantity() + 1);
                tourOfferCartEntry.setPrice(tourOfferCartEntry.getQuantity() * tourOfferCartEntry.getPrice());
            }
        }
        Optional<TourOfferUser> tourOfferUser = tourOfferUserRepository.findById(id);
        if (!isAlreadyInCart) {
            TourOfferCartEntry newTourOfferCartEntry = new TourOfferCartEntry();
            newTourOfferCartEntry.setPrice(tourOfferUser.get().getPrice());
            newTourOfferCartEntry.setQuantity(1);
            newTourOfferCartEntry.setTourOfferUser(tourOfferUser.get());
            entries.add(newTourOfferCartEntry);
        }
        if (tourOfferUser.get().getStock() <= 0) {
            throw new OutOfOffersException();
        }
        tourOfferUser.get().setStock(tourOfferUser.get().getStock() - 1);
        tourOfferUserService.update(id, tourOfferUser.get());

        List<TourOfferCartEntry> entries = tourOfferCart.getTourOfferCartEntries();
        double sum = 0;
        for(TourOfferCartEntry entry : entries) {
            sum = sum + entry.getPrice();
        }
        tourOfferCart.setTotalPrice(sum);
        tourOfferCartRepository.save(tourOfferCart);

    }

    public void finalizeCurrentOrder(Long id) {
        TourOfferCart tourOfferCart = tourOfferCartRepository.getById(id);
        tourOfferCart.setTourOfferCartStatus(TourOfferCartStatus.COMPLETED);
        tourOfferCartRepository.save(tourOfferCart);
    }

    public void calculatePrice(Long id) {
        Optional<TourOfferUser> tourOfferUserOptional = tourOfferUserRepository.findById(id);
        Integer numberOfAdults = tourOfferUser.getNumberOfAdult();
        Integer numberOfChildren = tourOfferUser.getNumberOfChildren();
        Double price = numberOfAdults * tourOfferAdmin.getPriceForAnAdult() + numberOfChildren *
                tourOfferAdmin.getPriceForAChild();
        tourOfferUserOptional.get().setPrice(price);

    }



}
