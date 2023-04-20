package ru.trapeznikov.didital_chief.students.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.trapeznikov.didital_chief.groups.dto.ShortGroupDto;

@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private ShortGroupDto group;
    private Double averageGrade;
}
