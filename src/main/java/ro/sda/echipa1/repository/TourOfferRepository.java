package ro.sda.echipa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.echipa1.entities.TourOffer;

import java.util.Locale;
import java.util.Optional;

@Repository
public interface TourOfferRepository extends JpaRepository<TourOffer, Long> {

    Optional<TourOffer> findById(Long id);


    Optional<TourOffer> findByNameIgnoreCase(String name);
}
