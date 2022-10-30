package pl.bikes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "bikes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

}
