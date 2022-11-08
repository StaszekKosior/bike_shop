package pl.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.bikes.model.Bike;
import pl.bikes.model.Product;

import java.util.List;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findAll();

    @Query("select max(b) from Bike b ORDER BY b.id DESC")
    Bike findLast();

    Product findFirstById(Long id);

    Product save(Product product);

    Product removeProductById(Long id);

}

