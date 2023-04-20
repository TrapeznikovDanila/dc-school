package ru.trapeznikov.didital_chief.teachers.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ShortTeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialization;
}
