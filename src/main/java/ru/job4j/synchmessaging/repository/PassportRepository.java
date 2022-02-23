package ru.job4j.synchmessaging.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.synchmessaging.model.Passport;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Репозиторий для работы с БД (применительно к проекту) Passport object
 * включая
 * загрузить паспорта, которые нужно заменить в ближайшие 3 месяца
 * загрузить паспорта чей срок вышел
 * найти паспорт по серии
 * найти паспорт по серии и номеру
 */
public interface PassportRepository extends CrudRepository<Passport, Integer> {

    @Query("select u from Passport as u where u.replace < ?1 and u.replace > ?2")
    public List<Passport> findPassportByReplaceBetween(Date finish, Date today);

    @Query("select u from Passport as u where u.replace < ?1")
    public List<Passport> findPassportByReplace(Date date);

    @Query("select c from Passport as c where c.seria = ?1")
    public Optional<List<Passport>> findPassportBySeria(String seria);

    @Query("select c from Passport as c where c.seria = ?1 and c.number = ?2")
    public Optional<Passport> findPassportBySeriaAndNumber(String seria, int number);
}
