package ro.sda.echipa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.echipa1.entities.TourOfferAdmin;

import java.util.Optional;

@Repository
public interface TourOfferAdminRepository extends JpaRepository<TourOfferAdmin, Long> {

    Optional<TourOfferAdmin> findById(Long id);


    Optional<TourOfferAdmin> findByNameIgnoreCase(String name);
}
