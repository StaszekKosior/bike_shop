package pl.bikes.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;


@Entity
@Table(name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

}
