package ru.trapeznikov.didital_chief.groups.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.trapeznikov.didital_chief.groups.dto.AddTeacherRequest;
import ru.trapeznikov.didital_chief.groups.dto.GroupDto;
import ru.trapeznikov.didital_chief.groups.dto.NewGroupRequest;
import ru.trapeznikov.didital_chief.groups.dto.UpdateGroupRequest;
import ru.trapeznikov.didital_chief.groups.service.GroupsService;

import java.util.List;

@RestController
@RequestMapping(path = "/groups")
@RequiredArgsConstructor
public class GroupsController {

    private final GroupsService service;

    @GetMapping
    public List<GroupDto> getGroups() {
        return service.getGroups();
    }

    @GetMapping("/{id}")
    public GroupDto getGroupById(@PathVariable Long id) {
        return service.getGroupById(id);
    }

    @PostMapping
    GroupDto createGroup(@RequestBody NewGroupRequest classRequest) {
        return service.createGroup(classRequest);
    }

    @PatchMapping
    public GroupDto updateGroup(@RequestBody UpdateGroupRequest classRequest) {
        return service.updateGroup(classRequest);
    }

    @PostMapping("/{groupId}/homeroomTeacher")
    public GroupDto addHomeroomTeacherToGroup(@PathVariable Long groupId, @RequestBody AddTeacherRequest teacherRequest) {
        return service.addHomeroomTeacherToGroup(groupId, teacherRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable Long id) {
        service.deleteGroup(id);
    }
}
