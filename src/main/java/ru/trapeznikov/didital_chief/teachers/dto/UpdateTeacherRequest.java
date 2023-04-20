package ru.trapeznikov.didital_chief.teachers.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UpdateTeacherRequest {
    @NotNull
    private Long id;
    private String lastName;
    private String specialization;
}
