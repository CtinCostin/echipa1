package ro.sda.echipa1.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa1.dto.TourOfferCartEntryDto;
import ro.sda.echipa1.entities.TourOfferCartEntry;
import ro.sda.echipa1.repository.TourOfferCartEntryRepository;

import java.util.List;

@Service
public class TourOfferCartEntryService {

    private TourOfferCartEntryRepository tourOfferCartEntryRepository;

    public TourOfferCartEntryService(TourOfferCartEntryRepository tourOfferCartEntryRepository) {
        this.tourOfferCartEntryRepository = tourOfferCartEntryRepository;
    }

    public TourOfferCartEntry addNewTourOfferCartEntry(TourOfferCartEntry tourOfferCartEntry) {
        return tourOfferCartEntryRepository.save(tourOfferCartEntry);
    }

    public List<TourOfferCartEntry> getAllTourOffersCartEntries() {
        return tourOfferCartEntryRepository.findAll();
    }

    public TourOfferCartEntry findById(Long id) {
        return tourOfferCartEntryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tour offer cart entry not found!"));
    }

    public void update(Long id, TourOfferCartEntryDto tourOfferCartEntryDto) {
        tourOfferCartEntryRepository.findById(id)
                .map(existingTourOfferCartEntry -> updateEntity(tourOfferCartEntryDto, existingTourOfferCartEntry))
                .map(updatedTourOfferCartEntry -> tourOfferCartEntryRepository.save(updatedTourOfferCartEntry))
                .orElseThrow(() -> new RuntimeException("Tour offer cart entry not found !"));


    }

    private TourOfferCartEntry updateEntity(TourOfferCartEntryDto tourOfferCartEntryDto, TourOfferCartEntry existingTourOfferCartEntry) {
        existingTourOfferCartEntry.setQuantity(tourOfferCartEntryDto.getQuantity());
        existingTourOfferCartEntry.setPrice(tourOfferCartEntryDto.getPrice());
        existingTourOfferCartEntry.setTourOfferUser(tourOfferCartEntryDto.getTourOffer());

        return existingTourOfferCartEntry;
    }

    @Transactional
    public void delete(Long id) {
        tourOfferCartEntryRepository.deleteById(id);
    }

    public void save(TourOfferCartEntry tourOfferCartEntry) {
        tourOfferCartEntryRepository.save(tourOfferCartEntry);
    }
}
