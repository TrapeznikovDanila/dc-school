package ru.trapeznikov.didital_chief.groups.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.trapeznikov.didital_chief.students.model.Student;
import ru.trapeznikov.didital_chief.teachers.model.Teacher;

import java.util.List;

@Entity
@Table(name = "groups")
@NoArgsConstructor
@Getter @Setter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int parallelNumber;
    private String letter;
    @OneToMany(mappedBy = "group")
    private List<Student> students;
    private int studentsAge;
    @OneToOne
    private Teacher homeroomTeacher;
}
