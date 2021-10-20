package ro.sda.echipa1.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.sda.echipa1.entities.User;
import ro.sda.echipa1.repository.UserRepository;

@Configuration
public class DbInit {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner initialData() {
        return args -> {
            // load initial data in db
            User admin = new User("admin", "pass", "ADMIN");
            User user = new User("user", "{bcrypt}$2y$12$92ZkDrGVS3W5ZJI.beRlEuyRCPrIRlkEHz6T.7MVmH38l4/VAHhyi", "USER");

            userRepository.save(admin);
            userRepository.save(user);
        };
    }
}
