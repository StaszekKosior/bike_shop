package pl.bikes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Table(name = "bikes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bike extends Product {

    @NotNull
    private String frameSize;

    @NotNull
    private String wheelsSize;


}
