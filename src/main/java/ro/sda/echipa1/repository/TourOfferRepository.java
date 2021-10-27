package ro.sda.echipa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.echipa1.entities.TourOffer;

import java.util.Locale;
import java.util.Optional;

public interface TourOfferRepository extends JpaRepository<TourOffer, Long> {
    @Override
    Optional<TourOffer> findById(Long id);


    Optional<TourOffer> findByNameIgnoreCase(String name);
}
