package ru.job4j.synchmessaging.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.synchmessaging.model.Passport;
import ru.job4j.synchmessaging.service.PassportService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/passport")
public class PassportController {

    private PassportService passportService;

    public PassportController(PassportService passportService) {
        this.passportService = passportService;
    }

    @GetMapping("/find")
    public List<Passport> findAll() {
        return StreamSupport.stream(
                this.passportService.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passport> findById(@PathVariable int id) {
        var person = this.passportService.findById(id);
        return new ResponseEntity<>(
                person.orElse(new Passport()),
                person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @GetMapping("/{seria}")
    public ResponseEntity<Passport> findById(@PathVariable String seria) {
        var person = this.passportService.findBySeria(seria);
        return new ResponseEntity<>(
                person.orElse(new Passport()),
                person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Passport> create(@RequestBody Passport passport) {
        return new ResponseEntity<>(
                this.passportService.save(passport),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Passport passport) {
        this.passportService.save(passport);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Passport passport = new Passport();
        passport.setId(id);
        this.passportService.delete(passport);
        return ResponseEntity.ok().build();
    }

    /** unavaliabe, загрузить паспорта чей срок вышел
     *
     * @return List<Object> + Response status
     */
    @GetMapping("/unavaliabe")
    public ResponseEntity<List<Passport>> findByDateExpiration() {
        var person = this.passportService.unavaliabe();
        return new ResponseEntity<>(person,
                !person.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * find-replaceable, загрузить паспорта, которые нужно заменить в ближайшие 3 месяца
     *
     * @return
     */
    @GetMapping("/find-replaceable")
    public ResponseEntity<List<Passport>> findByDateExpirationByThreeMounth() {
        var person = this.passportService.unavaliabe();
        return new ResponseEntity<>(person,
                !person.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }
}
