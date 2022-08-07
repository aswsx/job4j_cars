package ru.job4j.cars.persistence;

import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import ru.job4j.cars.models.Advertisement;

import java.util.List;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 07/08/2022 - 18:28
 */
@AllArgsConstructor
public class AdRepository implements DBStore {
    private final SessionFactory sf;

    /*
    показать объявления за последний день;
     */
    public List<Advertisement> TodayAdvs() {
        return tx(session -> session.createQuery(
                "select distinct a from Advertisement a "
                        + "join fetch a.car c "
                        + "join fetch a.user u "
                        + "join fetch c.engine e "
                        + "join fetch c.drivers where a.created > CURRENT_DATE").list(), sf);
    }


    /*
    показать объявления с фото;
     */
    public List<Advertisement> AdvsWithPhoto() {
        return tx(session -> session.createQuery(
                "select distinct a from Advertisement a "
                        + "join fetch a.car c "
                        + "join fetch a.user u "
                        + "join fetch c.engine e "
                        + "join fetch c.drivers where a.photo.size > 0").list(), sf
        );
    }

    /*
     показать объявления определенной марки.
     */
    public List<Advertisement> findAdvsByModelName(String modelName) {
        return tx(session -> session.createQuery(
                "select distinct a from Advertisement a "
                        + "join fetch a.car c "
                        + "join fetch a.user u "
                        + "join fetch c.engine e "
                        + "join fetch c.drivers where c.name= :modelName")
                .setParameter("modelName", modelName).list(), sf
        );
    }
}

