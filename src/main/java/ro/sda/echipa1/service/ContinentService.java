package ro.sda.echipa1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa1.entities.Continent;
import ro.sda.echipa1.repository.ContinentRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ContinentService {

    private ContinentRepository continentRepository;

    @Autowired
    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public Continent addNewContinent(Continent continent) {
        return continentRepository.save(continent);
    }

    public List<Continent> findAll() {
        return continentRepository.findAll();
    }

    public Continent findById(Long id) {
        Optional<Continent> continentOptional = continentRepository.findById(id);
        return continentOptional.orElseThrow(() -> new RuntimeException("Continent not found"));
    }


    @Transactional
    public void delete(Long id) {
        continentRepository.deleteById(id);
    }

    public void save(Continent continent) {
        continentRepository.save(continent);
    }
}
