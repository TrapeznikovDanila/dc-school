drop table if exists class_teacher;
drop table if exists students;
drop table if exists teachers;
drop table if exists groups;

CREATE TABLE IF NOT EXISTS groups (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL primary key,
    parallel_number INT NOT NULL,
    letter VARCHAR(1) NOT NULL,
    students_age INT NOT NULL,
    homeroom_teacher_id BIGINT
);

CREATE TABLE IF NOT EXISTS teachers (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL primary key,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    specialization VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS students (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL primary key,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    group_id BIGINT REFERENCES groups(id) ON DELETE CASCADE,
    average_grade FLOAT
);

CREATE TABLE class_teacher (
    group_id INTEGER REFERENCES groups(id),
    teacher_id INTEGER REFERENCES teachers(id),
    CONSTRAINT pk_class_teacher PRIMARY KEY (group_id, teacher_id)
);

