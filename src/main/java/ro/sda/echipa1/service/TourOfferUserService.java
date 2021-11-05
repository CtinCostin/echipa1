package ro.sda.echipa1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.echipa1.entities.TourOfferAdmin;
import ro.sda.echipa1.entities.TourOfferUser;
import ro.sda.echipa1.repository.TourOfferUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TourOfferUserService {

    private TourOfferUserRepository tourOfferUserRepository;

    private  TourOfferAdmin tourOfferAdmin;

    @Autowired
    public TourOfferUserService(TourOfferUserRepository tourOfferUserRepository) {
        this.tourOfferUserRepository = tourOfferUserRepository;

    }


    public List<TourOfferUser> findAll() {
        return tourOfferUserRepository.findAll();
    }


    public TourOfferUser findById(Long id) {
        return tourOfferUserRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Offer not found!"));
    }

    public void update(Long id, TourOfferUser tourOfferUser) {
        tourOfferUserRepository.findById(id)
                .map(existingTourOffer -> updateEntity(tourOfferUser, existingTourOffer))
                .map(updatedTourOffer -> tourOfferUserRepository.save(updatedTourOffer))
                .orElseThrow(() -> new RuntimeException("Offer not found!"));
    }

    private TourOfferUser updateEntity(TourOfferUser tourOfferUser, TourOfferUser existingTourOfferUser) {
        existingTourOfferUser.setTravelOption(tourOfferUser.getTravelOption());
        existingTourOfferUser.setCountry(tourOfferUser.getCountry());
        existingTourOfferUser.setCity(tourOfferUser.getCity());
        existingTourOfferUser.setAirport(tourOfferUser.getAirport());
        existingTourOfferUser.setDepartureDate(tourOfferUser.getDepartureDate());
        existingTourOfferUser.setNumberOfDays(tourOfferUser.getNumberOfDays());
        existingTourOfferUser.setNumberOfRooms(tourOfferUser.getNumberOfRooms());
        existingTourOfferUser.setTypeOfService(tourOfferUser.getTypeOfService());
        existingTourOfferUser.setNumberOfAdult(tourOfferUser.getNumberOfAdult());
        existingTourOfferUser.setNumberOfChildren(tourOfferUser.getNumberOfChildren());

        return existingTourOfferUser;
    }

    public void save(TourOfferUser tourOfferUser) {
        tourOfferUserRepository.save(tourOfferUser);
    }

    public void calculatePrice(Long id, TourOfferUser tourOfferUser) {
        Optional<TourOfferUser> tourOfferUserOptional = tourOfferUserRepository.findById(id);
        Integer numberOfAdults = tourOfferUser.getNumberOfAdult();
        Integer numberOfChildren = tourOfferUser.getNumberOfChildren();
        Double price = numberOfAdults * tourOfferAdmin.getPriceForAnAdult() + numberOfChildren *
                tourOfferAdmin.getPriceForAChild();
        tourOfferUserOptional.get().setPrice(price);

    }
}


