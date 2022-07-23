package ru.job4j.cars.models;

import lombok.*;

import javax.persistence.*;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 23/07/2022 - 14:02
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Driver of(String name) {
        Driver driver = new Driver();
        driver.name = name;
        return driver;
    }
}
