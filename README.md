# dc-school

Тестовое задание - описание предметной области "школа". Сущности: учитель(Teacher), ученик(Student), класс(Group). 
Между сущностями класс и ученик отношение один ко многим - в каждом классе много учеников, но каждый ученик состоит только в одном классе.
Между сущностями класс и учитель отношение многие ко многим - в каждом классе преподает несколько учителей, учитель преподает в нескольких классах.

### Стек
- Java 18
- Spring Boot
- Hibernate
- Lombok
- PostgreSQL
- Docker

## Файл pom.xml содержит следующие зависимости:
 - 'spring-boot-starter' - стандартный стартовый пакет Spring Boot, который включает в себя основные компоненты Spring.
 - 'spring-boot-starter-data-jpa' - стартовый пакет Spring Boot для работы с JPA (Java Persistence API), который включает в себя Hibernate, Spring Data JPA и другие необходимые зависимости.
 - 'spring-boot-starter-web' - стартовый пакет Spring Boot для создания веб-приложений, который включает в себя Spring MVC и Tomcat.
 - 'spring-boot-starter-validation' - стартовый пакет Spring Boot для валидации данных.
 - 'postgresql' - драйвер JDBC для работы с PostgreSQL базами данных.
 - 'lombok' - библиотека, которая облегчает написание кода, убирая необходимость в написании рутины и шаблонного кода.
 - 'spring-boot-starter-test' - стартовый пакет Spring Boot для тестирования приложений.

Примеры запросов к эндпоинтам находятся в корневой директории в файле 'school-curl-examples.txt'. ссылка - https://github.com/TrapeznikovDanila/dc-school/blob/master/school-curl-examples.txt

Тесты Postman расположены в папке 'postman' в корневой директории. Ссылка - https://github.com/TrapeznikovDanila/dc-school/blob/master/postman/school.postman_collection.json

Схема базы данных находится в файле 'dc-school-database-schema.pdf', файл расположен в корневой директории. Ссылка - https://github.com/TrapeznikovDanila/dc-school/blob/master/dc-school-database-schema.pdf
  
## Запуск приложения:
1) Клонируйте репозиторий (команда: git clone https://github.com/TrapeznikovDanila/dc-school.git)
2) Откройте проект в IDE (проект разрабатывался IntelliJ IDEA)
3) Сборка проекта командой - mvn clean package
4) Запуск проекта командой - docker-compose up





