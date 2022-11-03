package pl.bikes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    private User user;

    @ElementCollection
    @CollectionTable(name = "orders_bikes")
    @MapKeyColumn(name = "bike")
    Map<Bike, Integer> bikeMap = new HashMap<>();


    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void created() {
        LocalDateTime time = LocalDateTime.now();
        this.setUpdatedAt(time);
        this.setCreatedAt(time);
    }

    @PreUpdate
    public void update() {
        LocalDateTime time = LocalDateTime.now();
        this.setUpdatedAt(time);
    }

    public Order (User user, Map<Bike, Integer> bikesMap){
        this.user = user;
        this.bikeMap = bikesMap;
    }

}
