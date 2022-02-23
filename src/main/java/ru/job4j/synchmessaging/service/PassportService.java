package ru.job4j.synchmessaging.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.job4j.synchmessaging.model.Passport;

import ru.job4j.synchmessaging.repository.PassportRepository;

import java.util.*;

@Slf4j
@Service
public class PassportService {

    static final Logger LOGGER = LoggerFactory.getLogger(PassportService.class);

    private PassportRepository repository;

    public PassportService(PassportRepository repository) {
        this.repository = repository;
    }

    /**
     * Если сохраняется паспорт с той же серией и номером,
     * то возвращаем 400 (BatRequest) ошибку.
     *
     * @param passport
     * @return
     */
    public Passport save(Passport passport) {
        if (findIdenticalBySeriaAndNumber(passport.getSeria(), passport.getNumber())) {
            return passport;
        }
        return repository.save(passport);
    }

    /**
     * find using  seria and number from Passport obj in to BD
     *
     * @param serial
     * @param number
     * @return true if exist or false if not exist
     */
    private boolean findIdenticalBySeriaAndNumber(String serial, int number) {
        boolean rsl = false;
        var psprt = repository.findPassportBySeriaAndNumber(serial, number);
        if (psprt.isPresent()) {
            rsl = true;
            return rsl;
        }
        return rsl;
    }

    public Iterable<Passport> findAll() {
        return repository.findAll();
    }

    public Optional<Passport> findById(int id) {
        return repository.findById(id);
    }

    /**
     * Find Passport using as key String value seria passport
     *
     * @param seria Passport object
     * @return Optional<Passport>
     */
    public Optional<List<Passport>> findBySeria(String seria) {
        return repository.findPassportBySeria(seria);
    }

    public void delete(Passport passport) {
        repository.delete(passport);
    }

    /**
     * unavaliabe, загрузить паспорта чей срок вышел
     * показать просроченные
     *
     * @return
     */
    public List<Passport> showOverdue() {
        Date date = subtractDays(1, false);
        var rsl = repository.findPassportByReplace(date);
        LOGGER.info("То что нашли {}", rsl);
        return rsl;
    }

    /**
     * return Passport object to be replaced within the next 3 months
     *
     * @return List values Passport object
     */
    public List<Passport> findByDateMoreThenDay() {
        var finish = subtractDays(90, true);
        var today = subtractDays(0, true);
        var rsl = repository.findPassportByReplaceBetween(finish, today);
        LOGGER.info("То что нашли {}", rsl);
        return rsl;
    }

    /**
     * метод определение даты минус 1 день
     * или 90 дней, в зависимости от условия поиска
     * параметр метода - колличество дней минус от текущей даты
     * boolean flag - false minus true plus
     *
     * @return Date time one day before
     */
    private Date subtractDays(int day, boolean flag) {
        Date date = new Date(System.currentTimeMillis());
        int days = day;
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        if (!flag) {
            cal.add(Calendar.DATE, -days);
            return cal.getTime();
        }
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
