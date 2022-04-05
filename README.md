# simple project synchronous messaging

[![Build Status](https://app.travis-ci.com/SlartiBartFast-art/job4j_synchronous_messaging.svg?branch=master)](https://app.travis-ci.com/SlartiBartFast-art/job4j_synchronous_messaging)
![GitHub top language](https://img.shields.io/github/languages/top/SlartiBartFast-art/job4j_synchronous_messaging?logo=java&logoColor=red)
![GitHub last commit](https://img.shields.io/github/last-commit/SlartiBartFast-art/job4j_synchronous_messaging?logo=github)


Часть 1-я Provider

Приложение представляет из себя простой проект синхронного обмена сообщениями,
при использовании микросервисной архитектуры отображая организацию взаимодействие между сервисами.
Взаимодействие между сервисами построено используя REST API архитектуру.

Used stack technologies:

- Java (Back-end)

- Libraries (java):

- Hibernate HQL/ JPA (data-base)

- PostgreSQL PSQL (data-base)

- Spring Boot и архитектура REST API

- Maven
  
- Postman (Postman is an API platform for building and using APIs)

 Реализован подход синхронного обмена сообщениями клиент делает запрос и ждет "здесь и сейчас" ответ.
  
  Сервис заниматься управлением паспортами.
  Доменной моделью будет - паспорт.

Поддерживаються следующие методы:

- /find, загрузить все паспорта

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_synchronous_messaging/blob/master/image/Screenshot_1.jpg)


- /find?seria=*, загрузить паспорта с заданной серией

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_synchronous_messaging/blob/master/image/Screenshot_2.jpg)

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_synchronous_messaging/blob/master/image/Screenshot_6.jpg)

- /save, сохранить данные паспорта

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_synchronous_messaging/blob/master/image/Screenshot_3.jpg)

- при попытке сохранить уже существующий в БД объект Паспорт(проверка проводиться по серии и номеру паспорта)
  
![Image of Arch](https://github.com/SlartiBartFast-art/job4j_synchronous_messaging/blob/master/image/Screenshot_11.jpg)

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_synchronous_messaging/blob/master/image/Screenshot_10.jpg)

- /update?id=*, обновить данные паспорта

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_synchronous_messaging/blob/master/image/Screenshot_5.jpg)

- /delete?id=*, удалить данные паспорта

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_synchronous_messaging/blob/master/image/Screenshot_7.jpg)


- /unavaliabe, загрузить паспорта чей срок вышел

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_synchronous_messaging/blob/master/image/Screenshot_8.jpg)


- /find-replaceable, загрузить паспорта, которые нужно заменить в ближайшие 3 месяца

![Image of Arch](https://github.com/SlartiBartFast-art/job4j_synchronous_messaging/blob/master/image/Screenshot_9.jpg)


Часть 2-я Consumer - смотреть проект: https://github.com/SlartiBartFast-art/consumer_messaging (Spring RestTemplate)

