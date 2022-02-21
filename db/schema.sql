create table passport
(
    id             serial primary key,
    seria          varchar(255),
    number         int,
    code_department varchar(255),
    department     varchar(255),
    created        timestamp,
    replace        timestamp
);

insert into passport (seria, number, code_department, department, created, replace)
values ('45 07', 111222, '772-050', 'УВД по Московской Области','2007-02-19 14:45:26.3433256',
        '2032-02-20 15:23:14.9772768');
insert into passport (seria, number, code_department, department, created, replace)
values ('47 07', 111223, '772-050', 'УВД по Московской Области','1998-02-15 15:45:26.3433256',
        '2022-02-20 15:23:14.9772768');
insert into passport (seria, number, code_department, department, created, replace)
values ('49 07', 107223, '451-001', 'УВД по Курганской Области','2002-02-12 11:45:26.3433256',
        '2027-02-21 15:23:14.9772768');
insert into passport (seria, number, code_department, department, created, replace)
values ('39 14', 918223, '910-003', 'Отлдел УФМС России по Республике Крым','2007-02-19 14:45:26.3433256',
        '2032-04-11 15:23:14.9772768');

insert into passport (seria, number, code_department, department, created, replace)
values ('46 12', 882561, '500-037', 'УВД по Московской Области', '1997-02-15 15:45:26.3433256',
        '2022-05-17 15:23:14.9772768');

insert into passport (seria, number, code_department, department, created, replace)
values ('56 14', 800161, '150-037', 'УВД по Кемеровской Области', '2002-02-12 11:45:26.3433256',
        '2027-02-21 15:23:14.9772768');

insert into passport (seria, number, code_department, department, created, replace)
values ('45 07', 457789, '772-050', 'УВД по Московской Области','2008-02-19 14:45:26.3433256',
        '2033-02-20 15:23:14.9772768');