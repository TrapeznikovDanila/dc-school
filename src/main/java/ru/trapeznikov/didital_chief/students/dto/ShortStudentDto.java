package ru.trapeznikov.didital_chief.students.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.trapeznikov.didital_chief.groups.dto.GroupDto;

@NoArgsConstructor
@Getter @Setter
public class ShortStudentDto {
    private Long id;
    private String firstName;
    private String lastName;
}
