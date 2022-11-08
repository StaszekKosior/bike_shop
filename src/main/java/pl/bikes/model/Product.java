package pl.bikes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String producer;

    private String model;

    @NotNull
    @NotBlank
    @Size(max = 400)
    private String description;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;

    @NotNull
    @ManyToOne
    private Category category;

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
    public String getName() {
        return producer + " " + model;
    }
}
