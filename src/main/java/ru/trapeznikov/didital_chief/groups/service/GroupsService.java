package ru.trapeznikov.didital_chief.groups.service;

import ru.trapeznikov.didital_chief.groups.dto.AddTeacherRequest;
import ru.trapeznikov.didital_chief.teachers.dto.AddGroupRequest;
import ru.trapeznikov.didital_chief.groups.dto.GroupDto;
import ru.trapeznikov.didital_chief.groups.dto.NewGroupRequest;
import ru.trapeznikov.didital_chief.groups.dto.UpdateGroupRequest;

import java.util.List;

public interface GroupsService {
    List<GroupDto> getClasses();
    GroupDto getClassById(Long id);
    GroupDto createClass(NewGroupRequest classRequest);
    GroupDto updateClass(UpdateGroupRequest classRequest);
    GroupDto addHomeroomTeacherToClass(Long groupId, AddTeacherRequest teacherRequest);
    void deleteClass(Long id);
}
