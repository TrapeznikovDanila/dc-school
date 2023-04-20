package ru.trapeznikov.didital_chief.students.service;

import org.springframework.stereotype.Component;
import ru.trapeznikov.didital_chief.groups.service.GroupsMapper;
import ru.trapeznikov.didital_chief.students.dto.NewStudentRequest;
import ru.trapeznikov.didital_chief.students.dto.ShortStudentDto;
import ru.trapeznikov.didital_chief.students.dto.StudentDto;
import ru.trapeznikov.didital_chief.students.model.Student;

import java.util.Optional;

@Component
public class StudentsMapper {

    public static StudentDto toStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setAge(student.getAge());
        Optional.ofNullable(student.getAverageGrade()).ifPresent(studentDto::setAverageGrade);
        studentDto.setGroup(GroupsMapper.toShortGroupDto(student.getGroup()));
        return studentDto;
    }

    public static Student toStudent(NewStudentRequest studentRequest) {
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setAge(studentRequest.getAge());
        Optional.ofNullable(studentRequest.getAverageGrade())
                .ifPresent(student::setAverageGrade);
        return student;
    }

    public static ShortStudentDto toShortStudentDto(Student student) {
        ShortStudentDto shortStudentDto = new ShortStudentDto();
        shortStudentDto.setId(student.getId());
        shortStudentDto.setFirstName(shortStudentDto.getFirstName());
        shortStudentDto.setLastName(shortStudentDto.getLastName());
        return shortStudentDto;
    }
}
