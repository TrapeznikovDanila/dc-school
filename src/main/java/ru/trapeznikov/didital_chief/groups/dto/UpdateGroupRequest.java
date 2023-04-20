package ru.trapeznikov.didital_chief.groups.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class UpdateGroupRequest {
    @NotNull
    private Long id;
    private Integer parallelNumber;
    private String letter;
    private Integer studentsAge;
}
