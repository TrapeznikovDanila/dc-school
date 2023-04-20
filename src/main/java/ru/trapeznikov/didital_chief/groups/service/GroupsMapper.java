package ru.trapeznikov.didital_chief.groups.service;

import org.springframework.stereotype.Component;
import ru.trapeznikov.didital_chief.groups.dto.GroupDto;
import ru.trapeznikov.didital_chief.groups.dto.NewGroupRequest;
import ru.trapeznikov.didital_chief.groups.dto.ShortGroupDto;
import ru.trapeznikov.didital_chief.groups.model.Group;
import ru.trapeznikov.didital_chief.students.service.StudentsMapper;
import ru.trapeznikov.didital_chief.teachers.dto.TeacherDto;
import ru.trapeznikov.didital_chief.teachers.model.Teacher;
import ru.trapeznikov.didital_chief.teachers.service.TeacherMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupsMapper {

    public static Group toGroup(NewGroupRequest groupRequest) {
        Group group = new Group();
        group.setParallelNumber(groupRequest.getParallelNumber());
        group.setLetter(groupRequest.getLetter());
        group.setStudentsAge(groupRequest.getStudentsAge());
        return group;
    }

    public static GroupDto toGroupDto(Group group) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setParallelNumber(group.getParallelNumber());
        groupDto.setLetter(group.getLetter());
        groupDto.setStudentsAge(group.getStudentsAge());
        if (group.getHomeroomTeacher() != null) {
            groupDto.setHomeroomTeacher(TeacherMapper.toShortTeacherDto(group.getHomeroomTeacher()));
        }
//        if (group.getTeachers() != null) {
//            groupDto.setTeachers(group.getTeachers().stream()
//                    .map(TeacherMapper::toShortTeacherDto).collect(Collectors.toList()));
//        }
        if (group.getStudents() != null) {
            groupDto.setStudents(group.getStudents().stream()
                    .map(StudentsMapper::toShortStudentDto).collect(Collectors.toList()));
        }
        return groupDto;
    }

    public static ShortGroupDto toShortGroupDto(Group group) {
        ShortGroupDto shortGroupDto =new ShortGroupDto();
        shortGroupDto.setId(group.getId());
        shortGroupDto.setParallelNumber(group.getParallelNumber());
        shortGroupDto.setLetter(group.getLetter());
        shortGroupDto.setStudentsAge(group.getStudentsAge());
        if (group.getHomeroomTeacher() != null) {
            shortGroupDto.setHomeroomTeacher(TeacherMapper.toShortTeacherDto(group.getHomeroomTeacher()));
        }
        return shortGroupDto;
    }
}
