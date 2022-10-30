package pl.bikes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accessories")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Accessorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToMany
    @NotNull
    private List<Bike> bikesFits = new ArrayList<>();

    @NotNull
    private String description;

    @NotNull
    private Double price;

    @NotNull
    private Integer quantity;

}
