package ru.trapeznikov.didital_chief.teachers.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trapeznikov.didital_chief.teachers.model.Teacher;

public interface TeachersRepository extends JpaRepository<Teacher, Long> {
}
