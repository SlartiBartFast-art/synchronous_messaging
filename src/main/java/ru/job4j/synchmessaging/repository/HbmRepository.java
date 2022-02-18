package ru.job4j.synchmessaging.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.synchmessaging.model.Passport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Transactional
@Repository
public class HbmRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Passport> findUn() { //ru.job4j.cars.model.Post / ru.job4j.synch_messaging.model.Passport
     List<Passport> passports = new ArrayList<>();
      passports = entityManager
              .createQuery("from Passport as c where c.created < :finish ", Passport.class)
              .setParameter("finish", subtractDays())
              .getResultList();
       return passports;
    }

//    public List<Passport> findUn() { //ru.job4j.cars.model.Post
//        return  entityManager.createQuery("from Passport as c where c.created between now() and :finish", Passport.class)
////              .setParameter("start", Timestamp.valueOf(LocalDateTime.now()))
//                .setParameter("finish", subtractDays())
//                .getResultList();
//    }
    /**
     * метод определение даты минус 1 день
     *
     * @return Date time one day before
     */
    private Date subtractDays() {
        Date date = new Date(System.currentTimeMillis());
        int days = 1;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);
        return cal.getTime();
    }
}
