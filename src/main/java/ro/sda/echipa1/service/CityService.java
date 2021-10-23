package ro.sda.echipa1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.echipa1.dto.CityDto;
import ro.sda.echipa1.entities.City;
import ro.sda.echipa1.repository.CityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    private CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City addNewCity(City city) {
        return cityRepository.save(city);
    }


    public List<City> findAll() {
        return cityRepository.findAll();
    }


    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(
                () -> new RuntimeException("city not found!"));
    }

    public void update(Long id, CityDto cityDto) {
        cityRepository.findById(id)
                .map(existingCity -> updateEntity(cityDto, existingCity))
                .map(updatedCity -> cityRepository.save(updatedCity))
                .orElseThrow(() -> new RuntimeException("city not found"));
    }

    private City updateEntity(CityDto cityDto, City existingCity) {
        existingCity.setName(cityDto.getName());
        existingCity.setCountry(cityDto.getCountry());

        return existingCity;
    }

    public void updateNew(City city) {

        String name = city.getName();
        cityRepository.findByNameIgnoreCase(name)
                .filter(existingCity -> existingCity.getId().equals(city.getId()))
                .map(existingCity -> cityRepository.save(city))
                .orElseThrow(() -> {

                    throw new RuntimeException("city already exist");
                });
    }

    @Transactional
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    public void save(City city) {
        cityRepository.save(city);
    }
}
