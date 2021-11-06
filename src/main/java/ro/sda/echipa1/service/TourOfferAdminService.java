package ro.sda.echipa1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa1.dto.TourOfferAdminDto;
import ro.sda.echipa1.entities.TourOfferAdmin;
import ro.sda.echipa1.repository.TourOfferAdminRepository;

import java.util.List;

@Service
public class TourOfferAdminService {

    private TourOfferAdminRepository tourOfferAdminRepository;

    @Autowired
    public TourOfferAdminService(TourOfferAdminRepository tourOfferAdminRepository) {
        this.tourOfferAdminRepository = tourOfferAdminRepository;
    }

    public List<TourOfferAdmin> findAll() {
        return tourOfferAdminRepository.findAll();
    }


    public TourOfferAdmin findById(Long id) {
        return tourOfferAdminRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("tour not found!"));
    }

    public void update(Long id, TourOfferAdminDto tourOfferAdminDto) {
        tourOfferAdminRepository.findById(id)
                .map(existingTourOffer -> updateEntity(tourOfferAdminDto, existingTourOffer))
                .map(updatedTourOffer -> tourOfferAdminRepository.save(updatedTourOffer))
                .orElseThrow(() -> new RuntimeException("tour not found"));
    }

    private TourOfferAdmin updateEntity(TourOfferAdminDto tourOfferAdminDto, TourOfferAdmin existingTourOfferAdmin) {
        existingTourOfferAdmin.setName(tourOfferAdminDto.getName());
        existingTourOfferAdmin.setContinent(tourOfferAdminDto.getContinent());
        existingTourOfferAdmin.setCountry(tourOfferAdminDto.getCountry());
        existingTourOfferAdmin.setCity(tourOfferAdminDto.getCity());
        existingTourOfferAdmin.setAirport(tourOfferAdminDto.getAirport());
        existingTourOfferAdmin.setHotel(tourOfferAdminDto.getHotel());
        existingTourOfferAdmin.setDepartureDate(tourOfferAdminDto.getDepartureDate());
        existingTourOfferAdmin.setDateOfReturn(tourOfferAdminDto.getDateOfReturn());
        existingTourOfferAdmin.setNumberOfDays(tourOfferAdminDto.getNumberOfDays());
        existingTourOfferAdmin.setTypeOfService(tourOfferAdminDto.getTypeOfService());
        existingTourOfferAdmin.setPriceForAnAdult(tourOfferAdminDto.getPriceForAnAdult());
        existingTourOfferAdmin.setPriceForAChild(tourOfferAdminDto.getPriceForAChild());

        return existingTourOfferAdmin;
    }

    public void updateNew(TourOfferAdmin tourOfferAdmin) {

        String name = tourOfferAdmin.getName();
        tourOfferAdminRepository.findByNameIgnoreCase(name)
                .filter(existingTourOffer -> existingTourOffer.getId().equals(tourOfferAdmin.getId()))
                .map(existingTourOffer -> tourOfferAdminRepository.save(tourOfferAdmin))
                .orElseThrow(() -> {

                    throw new RuntimeException("tourOffer already exist");
                });
    }


    @Transactional
    public void delete(Long id) {
        tourOfferAdminRepository.deleteById(id);
    }

    public void save(TourOfferAdmin tourOfferAdmin) {
        tourOfferAdminRepository.save(tourOfferAdmin);
    }
}
