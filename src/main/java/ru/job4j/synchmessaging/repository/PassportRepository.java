package ru.job4j.synchmessaging.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.synchmessaging.model.Passport;

import java.util.Optional;

public interface PassportRepository extends CrudRepository<Passport, Integer> {

    public Optional<Passport> findPassportBySeria(String seria);
}
