package ru.job4j.synchmessaging.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.synchmessaging.model.Passport;

public interface PassportRepository extends CrudRepository<Passport, Integer> {

}
