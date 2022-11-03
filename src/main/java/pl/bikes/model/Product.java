package pl.bikes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


//@Entity
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {


    @NotNull
    private String producer;

    @NotNull
    private String model;

    @NotNull
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
}
