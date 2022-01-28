package ro.sda.echipa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.echipa1.dto.TourOfferCartDto;
import ro.sda.echipa1.entities.TourOfferCart;

import java.util.List;
import java.util.Optional;


@Repository
public interface TourOfferCartRepository extends JpaRepository<TourOfferCart, Long> {

   Optional<TourOfferCart> findById(Long id);

}
