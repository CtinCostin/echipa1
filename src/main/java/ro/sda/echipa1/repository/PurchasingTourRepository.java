package ro.sda.echipa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.echipa1.entities.PurchasingTour;

import java.util.Optional;


@Repository
public interface PurchasingTourRepository extends JpaRepository<PurchasingTour, Long> {

   Optional<PurchasingTour> findById(Long id);
}
