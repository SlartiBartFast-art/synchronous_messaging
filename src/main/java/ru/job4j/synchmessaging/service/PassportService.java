package ru.job4j.synchmessaging.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.job4j.synchmessaging.model.Passport;
import ru.job4j.synchmessaging.repository.HbmRepositoryImpl;
import ru.job4j.synchmessaging.repository.PassportRepository;

import java.util.*;

@Slf4j
@Service
public class PassportService {
    static final Logger LOGGER = LoggerFactory.getLogger(PassportService.class);

    private PassportRepository repository;
    private HbmRepositoryImpl hbmRepository;

    public PassportService(PassportRepository repository, HbmRepositoryImpl hbmRepository) {
        this.repository = repository;
        this.hbmRepository = hbmRepository;
    }

    public Passport save(Passport passport) {
        return repository.save(passport);
    }

    public Iterable<Passport> findAll() {
        return repository.findAll();
    }

    public Optional<Passport> findById(int id) {
        return repository.findById(id);
    }

    public Optional<Passport> findBySeria(String seria) {
        return repository.findPassportBySeria(seria);
    }

    public void delete(Passport passport) {
        repository.delete(passport);
    }

    /**
     * unavaliabe, загрузить паспорта чей срок вышел
     *
     * @return
     */
    public List<Passport> unavaliabe() {
        var rsl = hbmRepository.findUn();
        LOGGER.info("То что нашли {}", rsl);
        return rsl;
    }

    /**
     * return Passport object to be replaced within the next 3 months
     *
     * @return List values Passport object
     */
    public List<Passport> findByDateMoreThenDay() {
        var rsl = hbmRepository.replaceable();
        LOGGER.info("То что нашли {}", rsl);
        return rsl;
    }

//    private void convert(Timestamp timestamp) {
//        var st = timestamp.toString().split(" ");
//        System.out.println(st[0]);
//    }
}
