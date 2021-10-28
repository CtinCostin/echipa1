package ro.sda.echipa1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa1.dto.TourOfferDto;
import ro.sda.echipa1.entities.TourOffer;
import ro.sda.echipa1.repository.TourOfferRepository;

import java.util.List;

@Service
public class TourOfferService {

    private TourOfferRepository tourOfferRepository;

    @Autowired
    public TourOfferService(TourOfferRepository tourOfferRepository) {
        this.tourOfferRepository = tourOfferRepository;
    }

    public List<TourOffer> getAllTours() {
        return tourOfferRepository.findAll();
    }

    public List<TourOffer> findAll() {
        return tourOfferRepository.findAll();
    }


    public TourOffer findById(Long id) {
        return tourOfferRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("tour not found!"));
    }

    public void update(Long id, TourOfferDto tourOfferDto) {
        tourOfferRepository.findById(id)
                .map(existingTourOffer -> updateEntity(tourOfferDto, existingTourOffer))
                .map(updatedTourOffer -> tourOfferRepository.save(updatedTourOffer))
                .orElseThrow(() -> new RuntimeException("tour not found"));
    }

    private TourOffer updateEntity(TourOfferDto tourOfferDto, TourOffer existingTourOffer) {
        existingTourOffer.setContinent(tourOfferDto.getContinent());
        existingTourOffer.setCountry(tourOfferDto.getCountry());
        existingTourOffer.setCity(tourOfferDto.getCity());
        existingTourOffer.setAirport(tourOfferDto.getAirport());
        existingTourOffer.setHotel(tourOfferDto.getHotel());
        existingTourOffer.setDepartureDate(tourOfferDto.getDepartureDate());
        existingTourOffer.setDateOfReturn(tourOfferDto.getDateOfReturn());
        existingTourOffer.setNumberOfDays(tourOfferDto.getNumberOfDays());
        existingTourOffer.setTypeOfService(tourOfferDto.getTypeOfService());
        existingTourOffer.setPriceForAnAdult(tourOfferDto.getPriceForAnAdult());
        existingTourOffer.setPriceForAChild(tourOfferDto.getPriceForAChild());
        existingTourOffer.setIsPromoted(tourOfferDto.getPromoted());
        existingTourOffer.setNumberOfAdult(tourOfferDto.getNumberOfAdult());
        existingTourOffer.setNumberOfPLacesForChildren(tourOfferDto.getNumberOfPLacesForChildren());

        return existingTourOffer;
    }

    public void updateNew(TourOffer tourOffer) {

        String name = tourOffer.getName();
        tourOfferRepository.findByNameIgnoreCase(name)
                .filter(existingTourOffer -> existingTourOffer.getId().equals(tourOffer.getId()))
                .map(existingTourOffer -> tourOfferRepository.save(tourOffer))
                .orElseThrow(() -> {

                    throw new RuntimeException("tourOffer already exist");
                });
    }


    @Transactional
    public void delete(Long id) {
        tourOfferRepository.deleteById(id);
    }

    public void save(TourOffer tourOffer) {
        tourOfferRepository.save(tourOffer);
    }
}
