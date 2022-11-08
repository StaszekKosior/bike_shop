package pl.bikes.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "orders_products")
    @MapKeyColumn(name = "product")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    Map<Product, Integer> productsMap = new HashMap<>();

    private Double value;

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

    public Order (User user, Map<Product, Integer> productsMap, Double value){
        this.user = user;
        this.productsMap = productsMap;
        this.value = value;
    }

}
