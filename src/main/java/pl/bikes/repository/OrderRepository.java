package pl.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.bikes.model.Order;
import pl.bikes.model.User;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

      Order save(Order order);

      @Query("SELECT MAX(o) FROM Order o WHERE o.user = :user ORDER BY o.id DESC")
      Order findLast(@Param("user") User user);

}
