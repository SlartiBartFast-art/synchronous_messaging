package ru.job4j.synchmessaging.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.synchmessaging.model.Passport;
import ru.job4j.synchmessaging.service.PassportService;

import java.util.ArrayList;
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

    /**
     * Find all  objects Passport from DB
     * @return List<Passport>
     */
    @GetMapping("/find")
    public List<Passport> findAll() {
        return StreamSupport.stream(
                this.passportService.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    @GetMapping("/{seria}")
    public ResponseEntity<List<Passport>> findBySeria(@PathVariable String seria) {
        List<Passport> passports = new ArrayList<>();
        var person = this.passportService.findBySeria(seria);
        return new ResponseEntity<>(
                person.orElse(passports),
                person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    /**
     * Save Passport object in to DBase
     * if Passport obj is exist in to BD return Passport obj from DM anl  HttpStatus.CREATED
     * @param passport object
     * @return Passport object and HTTPStatus operftion created/bad_REQUEST
     */
    @PostMapping("/")
    public ResponseEntity<Passport> create(@RequestBody Passport passport) {
    Passport rsl = this.passportService.save(passport);
    if (rsl.getId() == 0) {
        return new ResponseEntity<>(
                passport,
                HttpStatus.BAD_REQUEST
        );
    }
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

    /**
     * Delete by used Id int
     * @param id int PKey from DB
     * @return HTTStatus.ok
     */
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
        var person = this.passportService.showOverdue();
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
        var person = this.passportService.findByDateMoreThenDay();
        return new ResponseEntity<>(person,
                !person.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }
}
