package ro.sda.echipa1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.echipa1.entities.City;
import ro.sda.echipa1.entities.Continent;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {

    List<Continent> findByName(String name);

    Optional<Continent> findByNameIgnoreCase(String name);
}
