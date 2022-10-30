package pl.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.bikes.model.Bike;
import pl.bikes.model.User;

import java.util.List;


@Repository
public interface UserRepositpry extends JpaRepository<User, Long> {

    List<User> findAll();

}

