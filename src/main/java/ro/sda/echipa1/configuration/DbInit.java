package ro.sda.echipa1.configuration;

import org.apache.el.parser.AstBracketSuffix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.echipa1.entities.*;
import ro.sda.echipa1.repository.UserRepository;
import ro.sda.echipa1.service.*;

import java.util.ArrayList;
import java.util.List;

import static ro.sda.echipa1.entities.StarRating.FIVE_STARS;
import static ro.sda.echipa1.entities.StarRating.ONE_STAR;

@Configuration
public class DbInit {

    @Autowired
    private HotelService hotelService;

//    @Autowired
//    private CountryService countryService;
//
//    @Autowired
//    private ContinentService continentService;
//
//    @Autowired
//    private CityService cityService;
//
//    @Autowired
//    private AirportService airportService;


    @Bean
    public CommandLineRunner initialData() {
        return args -> {
            // load initial data in db
            List<Country> countryList = new ArrayList<>();
            Continent europa = new Continent("Europa", countryList);
            Country romania = new Country("Romania", europa);
            City cluj = new City("Cluj Napoca", romania);
            Airport avramIancu = new Airport("Avram Iancu", cluj);
            Hotel ramada = new Hotel("Ramada", FIVE_STARS, "cel mai fain hotel", cluj);


        };
    }
}
