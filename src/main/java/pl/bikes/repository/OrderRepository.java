package pl.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import pl.bikes.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


      Order save(Order order);
}
