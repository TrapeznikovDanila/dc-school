package ru.trapeznikov.didital_chief.teachers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.trapeznikov.didital_chief.groups.dto.GroupDto;

import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class ShortTeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
}
