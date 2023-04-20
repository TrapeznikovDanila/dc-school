package ru.trapeznikov.didital_chief.students.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ChangeGroupRequest {
    @NotNull
    private Long groupId;
}
