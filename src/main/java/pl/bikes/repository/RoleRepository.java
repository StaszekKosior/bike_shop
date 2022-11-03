package pl.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bikes.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
