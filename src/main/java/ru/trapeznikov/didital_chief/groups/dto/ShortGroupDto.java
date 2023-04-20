package ru.trapeznikov.didital_chief.groups.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.trapeznikov.didital_chief.teachers.dto.ShortTeacherDto;

@NoArgsConstructor
@Getter @Setter
public class ShortGroupDto {
    private Long id;
    private int parallelNumber;
    private String letter;
    private int studentsAge;
    private ShortTeacherDto homeroomTeacher;
}
