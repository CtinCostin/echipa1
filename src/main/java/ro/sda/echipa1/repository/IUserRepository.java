package ro.sda.echipa1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.echipa1.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}