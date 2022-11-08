package pl.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bikes.model.Accessory;

import java.util.List;


@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {

    List<Accessory> findAll();

    Accessory findFirstById(Long id);

    Accessory save(Accessory accessory);


    List<Accessory> findAllByBikeIdEquals(Long id);


}

