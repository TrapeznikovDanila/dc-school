package ru.trapeznikov.didital_chief.students.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UpdateStudentRequest {
    @NotNull
    private Long id;
    private String lastName;
    private Double averageGrade;
}
