package ru.trapeznikov.didital_chief.students.service;

import ru.trapeznikov.didital_chief.students.dto.ChangeGroupRequest;
import ru.trapeznikov.didital_chief.students.dto.NewStudentRequest;
import ru.trapeznikov.didital_chief.students.dto.StudentDto;
import ru.trapeznikov.didital_chief.students.dto.UpdateStudentRequest;

import java.util.List;

public interface StudentsService {
    List<StudentDto> getStudents();

    StudentDto getStudentById(Long id);

    StudentDto addStudent(NewStudentRequest studentDto);

    StudentDto updateStudent(UpdateStudentRequest studentRequest);

    StudentDto changeGroup(Long studentId, ChangeGroupRequest changeGroupRequest);

    void deleteStudent(Long id);
}
