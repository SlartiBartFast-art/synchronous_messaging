package ru.job4j.synchmessaging.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * Доменная модель - паспорт
 * Date created -дата выдачи
 * Date replace -дата окончания дествия документа
 */
@Data
@EqualsAndHashCode
@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;
    @Column(name = "seria")
    private String seria;
    @Column(name = "number")
    private int number;
    @Column(name = "code_department")
    private String codeDepartment;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;
    @Column(name = "replace")
    private Date replace;
    @Column(name = "department")
    private String department;

    public Passport() {
    }

    public static Passport of(String seria) {
        Passport passport = new Passport();
        passport.seria = seria;
        return passport;
    }
}
