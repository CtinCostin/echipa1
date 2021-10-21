package ro.sda.echipa1.configuration;

import org.apache.el.parser.AstBracketSuffix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.echipa1.entities.*;
import ro.sda.echipa1.repository.UserRepository;
import ro.sda.echipa1.service.HotelService;

import static ro.sda.echipa1.entities.StarRating.ONE_STAR;

@Configuration
public class DbInit {

    @Autowired
    private HotelService hotelService;


    @Bean
    public CommandLineRunner initialData() {
        return args -> {
            // load initial data in db
            Continent europa = new Continent("Europa");
            Country country = new Country("Romania", europa);
            City Bucuresti = new City("Bucuresti", country);
            Hotel ramada = new Hotel(1l, "Ramada", ONE_STAR, "cel mai fain hotel", Bucuresti);
            hotelService.save(ramada);

        };
    }
}
