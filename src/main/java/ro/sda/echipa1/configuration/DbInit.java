package ro.sda.echipa1.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.echipa1.service.*;

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
//            List<Country> countryList = new ArrayList<>();
//            Continent europa = new Continent("Europa", countryList);
//            Country romania = new Country("Romania", europa);
//            City cluj = new City("Cluj Napoca", romania);
//            Airport avramIancu = new Airport("Avram Iancu", cluj);
//            Hotel ramada = new Hotel("Ramada", FIVE_STARS, "cel mai fain hotel", cluj);


        };
    }
}
