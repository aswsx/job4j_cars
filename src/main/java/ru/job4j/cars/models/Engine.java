package ru.job4j.cars.models;

import lombok.*;

import javax.persistence.*;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 23/07/2022 - 14:01
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "engines")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    public Engine of(String type) {
        Engine engine = new Engine();
        engine.type = type;
        return engine;
    }
}
