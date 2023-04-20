package ru.trapeznikov.didital_chief.students.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.trapeznikov.didital_chief.exception.NotFoundException;
import ru.trapeznikov.didital_chief.groups.dao.GroupsRepository;
import ru.trapeznikov.didital_chief.groups.model.Group;
import ru.trapeznikov.didital_chief.students.dao.StudentsRepository;
import ru.trapeznikov.didital_chief.students.dto.ChangeGroupRequest;
import ru.trapeznikov.didital_chief.students.dto.NewStudentRequest;
import ru.trapeznikov.didital_chief.students.dto.StudentDto;
import ru.trapeznikov.didital_chief.students.dto.UpdateStudentRequest;
import ru.trapeznikov.didital_chief.students.model.Student;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository repository;
    private final GroupsRepository groupsRepository;

    @Override
    public List<StudentDto> getStudents() {
        return repository.findAll().stream()
                .map(StudentsMapper::toStudentDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentsByGroupId(Long groupId) {
        getGroupFromDB(groupId);
        return repository.findByGroupId(groupId).stream()
                .map(StudentsMapper::toStudentDto).collect(Collectors.toList());

    }

    @Override
    public StudentDto getStudentById(Long id) {
        return StudentsMapper.toStudentDto(getStudentFromDB(id));
    }

    @Override
    public StudentDto addStudent(NewStudentRequest studentRequest) {
        Student newStudent = StudentsMapper.toStudent(studentRequest);
        List<Group> availableGroups = Optional.ofNullable(groupsRepository.findByStudentsAge(newStudent.getAge()))
                .orElseThrow(() -> new NotFoundException("A suitable age group was not found",
                        LocalDateTime.now()));
        Group group = availableGroups.stream().filter(g -> g.getStudents().size() < 20).findFirst()
                .orElseThrow(() -> new NotFoundException("A suitable age group was not found",
                        LocalDateTime.now()));
        newStudent.setGroup(group);

        return StudentsMapper.toStudentDto(repository.save(newStudent));
    }

    @Override
    public StudentDto updateStudent(UpdateStudentRequest studentRequest) {
        Student student = getStudentFromDB(studentRequest.getId());
        Optional.ofNullable(studentRequest.getLastName())
                .ifPresent(student::setLastName);
        Optional.ofNullable(studentRequest.getAverageGrade())
                .ifPresent(student::setAverageGrade);
        return StudentsMapper.toStudentDto(repository.save(student));
    }

    @Override
    public StudentDto changeGroup(Long studentId, ChangeGroupRequest changeGroupRequest) {
        Student student = getStudentFromDB(studentId);
        Group newGroup = getGroupFromDB(changeGroupRequest.getGroupId());
        student.setGroup(newGroup);
        return StudentsMapper.toStudentDto(repository.save(student));
    }

    @Override
    public void deleteStudent(Long id) {
        getStudentById(id);
        repository.deleteById(id);
    }

    private Student getStudentFromDB(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Student id=%s was not found", id),
                        LocalDateTime.now()));
    }

    private Group getGroupFromDB(Long id) {
        return groupsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Group id=%s was not found", id),
                        LocalDateTime.now()));
    }
}
