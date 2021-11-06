package ro.sda.echipa1.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ro.sda.echipa1.model.User;
import ro.sda.echipa1.web.dto.UserRegistrationDto;

public interface IUserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
    User findByUsername(String username);
}