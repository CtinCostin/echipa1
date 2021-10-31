package ro.sda.echipa1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa1.dto.TourOfferCartDto;
import ro.sda.echipa1.entities.TourOfferCart;
import ro.sda.echipa1.repository.TourOfferCartRepository;

import java.util.List;

@Service
public class TourOfferCartService {

    private TourOfferCartRepository tourOfferCartRepository;

    @Autowired
    public TourOfferCartService(TourOfferCartRepository tourOfferCartRepository) {
        this.tourOfferCartRepository = tourOfferCartRepository;
    }

    public TourOfferCart addNewTourOffer(TourOfferCart tourOfferCart) {
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
}
