package ru.trapeznikov.didital_chief.teachers.service;

import ru.trapeznikov.didital_chief.teachers.dto.AddGroupRequest;
import ru.trapeznikov.didital_chief.teachers.dto.NewTeacherRequest;
import ru.trapeznikov.didital_chief.teachers.dto.TeacherDto;
import ru.trapeznikov.didital_chief.teachers.dto.UpdateTeacherRequest;

import java.util.List;

public interface TeachersService {
    List<TeacherDto> getTeachers();

    TeacherDto getTeacherById(Long id);

    TeacherDto addTeacher(NewTeacherRequest teacherDto);

    TeacherDto updateTeacher(UpdateTeacherRequest teacherDto);

    TeacherDto addGroupToTeacher(Long teacherId, AddGroupRequest groupRequest);

    void deleteGroupFromTeacher(Long teacherId, Long groupId);

    void deleteTeacher(Long id);
}
