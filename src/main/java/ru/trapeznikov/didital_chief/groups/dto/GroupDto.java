package ru.trapeznikov.didital_chief.groups.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.trapeznikov.didital_chief.students.dto.ShortStudentDto;
import ru.trapeznikov.didital_chief.teachers.dto.ShortTeacherDto;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class GroupDto {
    private Long id;
    private int parallelNumber;
    private String letter;
    private List<ShortStudentDto> students;
    private int studentsAge;
    private ShortTeacherDto homeroomTeacher;
}
