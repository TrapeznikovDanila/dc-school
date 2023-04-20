package ru.trapeznikov.didital_chief.teachers.service;

import org.springframework.stereotype.Component;
import ru.trapeznikov.didital_chief.groups.service.GroupsMapper;
import ru.trapeznikov.didital_chief.teachers.dto.NewTeacherRequest;
import ru.trapeznikov.didital_chief.teachers.dto.ShortTeacherDto;
import ru.trapeznikov.didital_chief.teachers.dto.TeacherDto;
import ru.trapeznikov.didital_chief.teachers.model.Teacher;

import java.util.stream.Collectors;

@Component
public class TeacherMapper {

    public static Teacher toTeacher(NewTeacherRequest teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setAge(teacherDto.getAge());
        teacher.setSpecialization(teacherDto.getSpecialization());
        return teacher;
    }

    public static TeacherDto toTeacherDto(Teacher teacher) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(teacher.getId());
        teacherDto.setFirstName(teacher.getFirstName());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setAge(teacher.getAge());
        teacherDto.setSpecialization(teacher.getSpecialization());
        if (teacher.getGroups() != null) {
            teacherDto.setGroups(teacher.getGroups().stream()
                    .map(GroupsMapper::toShortGroupDto).collect(Collectors.toList()));
        }
        return teacherDto;
    }

    public static ShortTeacherDto toShortTeacherDto(Teacher teacher) {
        ShortTeacherDto shortTeacherDto = new ShortTeacherDto();
        shortTeacherDto.setId(teacher.getId());
        shortTeacherDto.setFirstName(teacher.getFirstName());
        shortTeacherDto.setLastName(teacher.getLastName());
        shortTeacherDto.setSpecialization(teacher.getSpecialization());
        return shortTeacherDto;
    }
}
