package ru.trapeznikov.didital_chief.groups.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AddTeacherRequest {
    @NotNull
    private Long teacherId;
}
