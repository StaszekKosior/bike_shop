package pl.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bikes.model.Bike;

import java.util.List;


@Repository
public interface BikeRepositpry extends JpaRepository<Bike, Long> {

    List<Bike> findAll();


}

