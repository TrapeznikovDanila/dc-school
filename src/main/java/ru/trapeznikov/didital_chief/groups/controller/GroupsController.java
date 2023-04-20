package ru.trapeznikov.didital_chief.groups.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.trapeznikov.didital_chief.groups.dto.AddTeacherRequest;
import ru.trapeznikov.didital_chief.teachers.dto.AddGroupRequest;
import ru.trapeznikov.didital_chief.groups.service.GroupsService;
import ru.trapeznikov.didital_chief.groups.dto.GroupDto;
import ru.trapeznikov.didital_chief.groups.dto.NewGroupRequest;
import ru.trapeznikov.didital_chief.groups.dto.UpdateGroupRequest;

import java.util.List;

@RestController
@RequestMapping(path = "/groups")
@RequiredArgsConstructor
public class GroupsController {

    private final GroupsService service;

    @GetMapping
    public List<GroupDto> getClasses() {
        return service.getClasses();
    }

    @GetMapping("/{id}")
    public GroupDto getClassById(@PathVariable Long id) {
        return service.getClassById(id);
    }

    @PostMapping
    GroupDto createClass(@RequestBody NewGroupRequest classRequest) {
        return service.createClass(classRequest);
    }

    @PatchMapping
    public GroupDto updateClass(@RequestBody UpdateGroupRequest classRequest) {
        return service.updateClass(classRequest);
    }

    @PostMapping("/{groupId}/homeroomTeacher")
    public GroupDto addHomeroomTeacherToClass(@PathVariable Long groupId, @RequestBody AddTeacherRequest teacherRequest) {
        return service.addHomeroomTeacherToClass(groupId, teacherRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        service.deleteClass(id);
    }
}
