package ru.trapeznikov.didital_chief.groups.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class NewGroupRequest {
    private int parallelNumber;
    private String letter;
    private int studentsAge;
}
