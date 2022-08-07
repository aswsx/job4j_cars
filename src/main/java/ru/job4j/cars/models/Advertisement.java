package ru.job4j.cars.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Alex Gutorov
 * @version 1.4
 * @created 07/08/2022 - 14:48
 */
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "advs")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private boolean sold;
    private byte[] photo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @ManyToOne
    @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "CAR_ID_FK"))
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private User user;

    public Advertisement of(String description) {
        Advertisement adv = new Advertisement();
        adv.description = description;
        return adv;
    }
}
