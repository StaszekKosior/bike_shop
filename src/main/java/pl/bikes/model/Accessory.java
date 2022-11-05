package pl.bikes.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accessories")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Accessory extends Product {


    private Integer size;

    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Bike> bike = new ArrayList<>();
}
