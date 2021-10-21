package ro.sda.echipa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.echipa1.entities.City;
import ro.sda.echipa1.entities.Hotel;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByName(String name);
    Optional<Hotel> findByNameIgnoreCase(String name);


}
