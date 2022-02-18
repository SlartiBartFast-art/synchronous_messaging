package ru.job4j.synchmessaging.service;

import org.springframework.stereotype.Service;
import ru.job4j.synchmessaging.model.Passport;
import ru.job4j.synchmessaging.repository.PassportRepository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PassportService {

    private PassportRepository repository;

    public PassportService(PassportRepository repository) {
        this.repository = repository;
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

    //TODO
     //unavaliabe, загрузить паспорта чей срок вышел
    public List<Passport> unavaliabe() {
        List<Passport> passports = new ArrayList<>();
      var rsl = StreamSupport.stream(
                this.findAll().spliterator(), false
        ).collect(Collectors.toList());
        var dateToday = LocalDateTime.now();

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        System.out.println(timestamp);
        var st = timestamp.toString().split(" ");
        System.out.println(st[0]);
        Date d = new Date(System.currentTimeMillis());
        System.out.println(d);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        var rt =  formatter.format(d);
        System.out.println("->" + rt);
        var gf = rt.split(" ");
        System.out.println(gf[0]);

        return passports;
    }

    private void convert(Timestamp timestamp) {
        var st = timestamp.toString().split(" ");
        System.out.println(st[0]);
    }

 //find-replaceable, загрузить паспорта, которые нужно заменить в ближайшие 3 месяца
}
