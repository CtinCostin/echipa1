package ro.sda.echipa1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.echipa1.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}