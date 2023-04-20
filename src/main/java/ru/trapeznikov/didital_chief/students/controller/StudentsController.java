package ru.trapeznikov.didital_chief.students.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.trapeznikov.didital_chief.students.dto.ChangeGroupRequest;
import ru.trapeznikov.didital_chief.students.dto.NewStudentRequest;
import ru.trapeznikov.didital_chief.students.dto.StudentDto;
import ru.trapeznikov.didital_chief.students.service.StudentsService;
import ru.trapeznikov.didital_chief.students.dto.UpdateStudentRequest;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService service;

    @GetMapping
    public List<StudentDto> getStudents() {
        return service.getStudents();
    }

    @GetMapping("/group/{groupId}")
    public List<StudentDto> getStudentsByClassId(@PathVariable Long groupId) {
        return service.getStudentsByGroupId(groupId);
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PostMapping
    public StudentDto addStudent(@RequestBody NewStudentRequest studentDto) {
        return service.addStudent(studentDto);
    }

    @PatchMapping
    public StudentDto updateStudent(@RequestBody UpdateStudentRequest studentRequest) {
        return service.updateStudent(studentRequest);
    }

    @PatchMapping("/{studentId}/group")
    public StudentDto changeGroup(@PathVariable Long studentId, @RequestBody ChangeGroupRequest changeGroupRequest) {
        return service.changeGroup(studentId, changeGroupRequest);
    }

    @DeleteMapping("/{id}")
    void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}
