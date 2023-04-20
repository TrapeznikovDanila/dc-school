package ru.trapeznikov.didital_chief.students.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trapeznikov.didital_chief.students.model.Student;

public interface StudentsRepository extends JpaRepository<Student, Long> {
}
