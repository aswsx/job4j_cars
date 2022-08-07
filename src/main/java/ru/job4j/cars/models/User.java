package ru.job4j.cars.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 26/07/2022 - 15:27
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
}
