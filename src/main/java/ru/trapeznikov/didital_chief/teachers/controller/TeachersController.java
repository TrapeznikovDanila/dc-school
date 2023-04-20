package ru.trapeznikov.didital_chief.teachers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.trapeznikov.didital_chief.teachers.dto.AddGroupRequest;
import ru.trapeznikov.didital_chief.groups.dto.GroupDto;
import ru.trapeznikov.didital_chief.teachers.dto.NewTeacherRequest;
import ru.trapeznikov.didital_chief.teachers.dto.TeacherDto;
import ru.trapeznikov.didital_chief.teachers.service.TeachersService;
import ru.trapeznikov.didital_chief.teachers.dto.UpdateTeacherRequest;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeachersController {

    private final TeachersService service;

    @GetMapping
    public List<TeacherDto> getTeachers() {
        return service.getTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDto getTeacherById(@PathVariable Long id) {
        return service.getTeacherById(id);
    }

    @PostMapping
    public TeacherDto addTeacher(@RequestBody NewTeacherRequest teacherDto) {
        return service.addTeacher(teacherDto);
    }

    @PatchMapping
    public TeacherDto updateTeacher(@RequestBody UpdateTeacherRequest teacherDto) {
        return service.updateTeacher(teacherDto);
    }

    @PostMapping("/{teacherId}/group")
    public TeacherDto addTeacherToClass(@PathVariable Long teacherId, @RequestBody AddGroupRequest groupRequest) {
        return service.addGroupToTeacher(teacherId, groupRequest);
    }

    @DeleteMapping("/{teacherId}/group/{groupId}")
    public void deleteGroupFromTeacher(@PathVariable Long teacherId, @PathVariable Long groupId) {
        service.deleteGroupFromTeacher(teacherId, groupId);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        service.deleteTeacher(id);
    }

}
