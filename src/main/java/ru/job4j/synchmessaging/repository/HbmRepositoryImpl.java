package ru.job4j.synchmessaging.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.synchmessaging.model.Passport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PessimisticLockException;
import java.util.*;

@Transactional
@Repository
public class HbmRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * /unavaliabe, загрузить паспорта чей срок вышел
     *
     * @return
     */
    public List<Passport> findUn() {
        List<Passport> passports = new ArrayList<>();
        passports = entityManager
                .createQuery("select c from Passport as c where c.created < :finish ", Passport.class)
                .setParameter("finish", subtractDays(1))
                .getResultList();
        return passports;
    }

    /**
     * find-replaceable, загрузить паспорта, которые нужно заменить в ближайшие 3 месяца
     *
     * @return
     */
    public List<Passport> replaceable() {
        List<Passport> passports = new ArrayList<>();
        passports = entityManager
                .createQuery("select c from Passport as c where c.created < :finish ", Passport.class)
                .setParameter("finish", subtractDays(90))
                .getResultList();
        return passports;
    }

    /**
     * метод определение даты минус 1 день
     * или 90 дней, в зависимости от условия поиска
     * параметр метода - колличество дней минус от текущей даты
     *
     * @return Date time one day before
     */
    private Date subtractDays(int day) {
        Date date = new Date(System.currentTimeMillis());
        int days = day;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);
        return cal.getTime();
    }

}
