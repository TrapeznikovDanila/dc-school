package ru.trapeznikov.didital_chief.teachers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.trapeznikov.didital_chief.groups.dto.ShortGroupDto;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String specialization;
    private List<ShortGroupDto> groups;
}
