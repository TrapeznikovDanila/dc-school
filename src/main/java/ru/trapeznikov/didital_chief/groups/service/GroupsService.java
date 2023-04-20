package ru.trapeznikov.didital_chief.groups.service;

import ru.trapeznikov.didital_chief.groups.dto.AddTeacherRequest;
import ru.trapeznikov.didital_chief.groups.dto.GroupDto;
import ru.trapeznikov.didital_chief.groups.dto.NewGroupRequest;
import ru.trapeznikov.didital_chief.groups.dto.UpdateGroupRequest;

import java.util.List;

public interface GroupsService {
    List<GroupDto> getGroups();

    GroupDto getGroupById(Long id);

    GroupDto createGroup(NewGroupRequest classRequest);

    GroupDto updateGroup(UpdateGroupRequest classRequest);

    GroupDto addHomeroomTeacherToGroup(Long groupId, AddTeacherRequest teacherRequest);

    void deleteGroup(Long id);
}
