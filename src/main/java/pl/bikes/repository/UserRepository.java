package pl.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bikes.model.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User findByEmail(String email);

}

