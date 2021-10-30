package ro.sda.echipa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.echipa1.entities.TourOfferCartEntry;

import java.util.Optional;

@Repository
public interface TourOfferCartEntryRepository extends JpaRepository<TourOfferCartEntry, Long> {

    Optional<TourOfferCartEntry> findById(Long id);
}
