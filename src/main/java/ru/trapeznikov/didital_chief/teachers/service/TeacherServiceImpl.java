package ru.trapeznikov.didital_chief.teachers.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trapeznikov.didital_chief.exception.NotFoundException;
import ru.trapeznikov.didital_chief.exception.ValidationException;
import ru.trapeznikov.didital_chief.groups.dao.GroupsRepository;
import ru.trapeznikov.didital_chief.groups.model.Group;
import ru.trapeznikov.didital_chief.teachers.dao.TeachersRepository;
import ru.trapeznikov.didital_chief.teachers.dto.AddGroupRequest;
import ru.trapeznikov.didital_chief.teachers.dto.NewTeacherRequest;
import ru.trapeznikov.didital_chief.teachers.dto.TeacherDto;
import ru.trapeznikov.didital_chief.teachers.dto.UpdateTeacherRequest;
import ru.trapeznikov.didital_chief.teachers.model.Teacher;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TeacherServiceImpl implements TeachersService {

    private final TeachersRepository repository;

    private final GroupsRepository groupsRepository;

    @Override
    public List<TeacherDto> getTeachers() {
        log.info("Requested a list of all teachers");
        return repository.findAll().stream()
                .map(TeacherMapper::toTeacherDto).collect(Collectors.toList());
    }

    @Override
    public TeacherDto getTeacherById(Long id) {
        log.info(String.format("Requested information about teacher id=%s", id));
        return TeacherMapper.toTeacherDto(getTeacherFromDB(id));
    }

    @Override
    public TeacherDto addTeacher(NewTeacherRequest teacherDto) {
        Teacher teacher = repository.save(TeacherMapper.toTeacher(teacherDto));
        log.info(String.format("Created teacher id=%s", teacher.getId()));
        return TeacherMapper.toTeacherDto(teacher);
    }

    @Override
    public TeacherDto updateTeacher(UpdateTeacherRequest teacherDto) {
        Teacher teacher = getTeacherFromDB(teacherDto.getId());
        Optional.ofNullable(teacherDto.getLastName()).ifPresent(teacher::setLastName);
        Optional.ofNullable(teacherDto.getSpecialization()).ifPresent(teacher::setSpecialization);
        Teacher updatedTeacher = repository.save(teacher);
        log.info(String.format("Updated teacher id=%s", updatedTeacher.getId()));
        return TeacherMapper.toTeacherDto(updatedTeacher);
    }

    @Override
    public TeacherDto addGroupToTeacher(Long teacherId, AddGroupRequest groupRequest) {
        Teacher teacher = getTeacherFromDB(teacherId);
        Group group = getGroupFromDB(groupRequest.getGroupId());
        List<Group> groups = teacher.getGroups();
        if (groups.size() > 10) {
            throw new ValidationException("Teacher can't have more than 10 groups", LocalDateTime.now());
        }
        groups.add(group);
        teacher.setGroups(groups);
        repository.save(teacher);
        log.info(String.format("Group id=%s1 was added to teacher id=%s2",
                groupRequest.getGroupId(), teacherId));
        return TeacherMapper.toTeacherDto(teacher);
    }

    @Override
    public void deleteGroupFromTeacher(Long teacherId, Long groupId) {
        Teacher teacher = getTeacherFromDB(teacherId);
        Group group = getGroupFromDB(groupId);
        List<Group> groups = teacher.getGroups();
        groups.remove(group);
        teacher.setGroups(groups);
        repository.save(teacher);
        log.info(String.format("Group id=%s1 was deleted from teacher id=%s2",
                groupId, teacherId));
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher teacher = getTeacherFromDB(id);
        if (teacher.getGroups().size() > 0) {
            throw new ValidationException("Only a teacher without classes can be removed from the system",
                    LocalDateTime.now());
        }
        repository.deleteById(id);
        log.info(String.format("Deleted teacher id=%s", id));
    }

    private Teacher getTeacherFromDB(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Teacher id=%s was not found", id),
                        LocalDateTime.now()));
    }

    private Group getGroupFromDB(Long id) {
        return groupsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Group id=%s was not found", id),
                        LocalDateTime.now()));
    }
}
