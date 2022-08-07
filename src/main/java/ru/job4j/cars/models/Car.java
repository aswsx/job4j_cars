package ru.job4j.cars.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex Gutorov
 * @version 1.6
 * @created 23/07/2022 - 14:02
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    private boolean sold;

    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "history_owners", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "car_id", nullable = false, updatable = false)})
    private Set<User> drivers = new HashSet<>();

    private byte[] photo;

    public Car of(String name, String description, String body, Engine engine) {
        Car car = new Car();
        car.name = name;
        car.description = description;
        car.body = body;
        car.engine = engine;
        return car;
    }
}
