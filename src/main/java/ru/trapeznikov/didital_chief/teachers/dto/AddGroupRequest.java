package ru.trapeznikov.didital_chief.teachers.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AddGroupRequest {
    @NotNull
    private Long groupId;
}
