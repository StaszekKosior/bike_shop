package pl.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bikes.model.Bike;

import java.util.List;


@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {

    List<Bike> findAll();

    @Query("select max(b) from Bike b ORDER BY b.id DESC")
    Bike findLast();
}

