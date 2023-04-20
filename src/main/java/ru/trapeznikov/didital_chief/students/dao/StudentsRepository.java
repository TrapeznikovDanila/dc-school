package ru.trapeznikov.didital_chief.students.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.trapeznikov.didital_chief.students.model.Student;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s " +
            "FROM Student s " +
            "WHERE s.group.id = :groupId " +
            "ORDER BY s.lastName")
    List<Student> findByGroupId(Long groupId);
}
