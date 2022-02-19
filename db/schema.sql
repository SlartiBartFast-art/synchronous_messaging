create table passport
(
    id         serial primary key,
    seria      varchar(255),
    department varchar(255),
    created    timestamp,
    replace    timestamp
);

insert into passport (created, department, number, seria)
values ('2022-02-19 14:45:26.3433256',
        'УВД по Московской Области', 111222, 'XIIFRA');
insert into passport (created, department, number, seria)
values ('2022-02-15 14:45:26.3433256',
        'УВД по Московской Области', 111333, 'XIIFRA');
insert into passport (created, department, number, seria)
values ('2022-02-12 14:45:26.3433256',
        'УВД по Московской Области', 555444, 'XIIFRA');