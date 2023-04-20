package ru.trapeznikov.didital_chief.groups.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trapeznikov.didital_chief.exception.NotFoundException;
import ru.trapeznikov.didital_chief.groups.dao.GroupsRepository;
import ru.trapeznikov.didital_chief.groups.dto.AddTeacherRequest;
import ru.trapeznikov.didital_chief.groups.dto.GroupDto;
import ru.trapeznikov.didital_chief.groups.dto.NewGroupRequest;
import ru.trapeznikov.didital_chief.groups.dto.UpdateGroupRequest;
import ru.trapeznikov.didital_chief.groups.model.Group;
import ru.trapeznikov.didital_chief.teachers.dao.TeachersRepository;
import ru.trapeznikov.didital_chief.teachers.model.Teacher;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class GroupsServiceImpl implements GroupsService {

    private final GroupsRepository repository;
    private final TeachersRepository teachersRepository;

    @Override
    public List<GroupDto> getClasses() {
        return repository.findAll().stream()
                .map(GroupsMapper::toGroupDto).collect(Collectors.toList());
    }

    @Override
    public GroupDto getClassById(Long id) {
        return GroupsMapper.toGroupDto(getGroupFromDB(id));
    }

    @Override
    public GroupDto createClass(NewGroupRequest classRequest) {
        return GroupsMapper.toGroupDto(repository.save(GroupsMapper.toGroup(classRequest)));
    }

    @Override
    public GroupDto updateClass(UpdateGroupRequest classRequest) {
        Group group = getGroupFromDB(classRequest.getId());
        Optional.ofNullable(classRequest.getParallelNumber()).ifPresent(group::setParallelNumber);
        Optional.ofNullable(classRequest.getLetter()).ifPresent(group::setLetter);
        Optional.ofNullable(classRequest.getStudentsAge()).ifPresent(group::setStudentsAge);
        repository.save(group);

        return GroupsMapper.toGroupDto(group);
    }

    @Override
    public GroupDto addHomeroomTeacherToClass(Long groupId, AddTeacherRequest teacherRequest) {
        Group group = getGroupFromDB(groupId);
        Teacher teacher = getTeacherFromDB(teacherRequest.getTeacherId());
        group.setHomeroomTeacher(teacher);
        repository.save(group);
        return GroupsMapper.toGroupDto(group);
    }

    @Override
    public void deleteClass(Long id) {
        getGroupFromDB(id);
        repository.deleteById(id);
    }

    private Group getGroupFromDB(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Group id=%s was not found", id),
                        LocalDateTime.now()));
    }

    private Teacher getTeacherFromDB(Long id) {
        return teachersRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Teacher id=%s was not found", id),
                        LocalDateTime.now()));
    }
}
