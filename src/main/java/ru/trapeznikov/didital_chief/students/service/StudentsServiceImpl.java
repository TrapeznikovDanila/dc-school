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
        log.info("Requested a list of all students");
        return repository.findAll().stream()
                .map(StudentsMapper::toStudentDto).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentById(Long id) {
        log.info(String.format("Requested information about student id=%s", id));
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
        Student savedStudent = repository.save(newStudent);
        log.info(String.format("Created student id=%s", savedStudent.getId()));
        return StudentsMapper.toStudentDto(savedStudent);
    }

    @Override
    public StudentDto updateStudent(UpdateStudentRequest studentRequest) {
        Student student = getStudentFromDB(studentRequest.getId());
        Optional.ofNullable(studentRequest.getLastName())
                .ifPresent(student::setLastName);
        Optional.ofNullable(studentRequest.getAverageGrade())
                .ifPresent(student::setAverageGrade);
        Student updatedStudent = repository.save(student);
        log.info(String.format("Updated student id=%s", updatedStudent.getId()));
        return StudentsMapper.toStudentDto(updatedStudent);
    }

    @Override
    public StudentDto changeGroup(Long studentId, ChangeGroupRequest changeGroupRequest) {
        Student student = getStudentFromDB(studentId);
        Group newGroup = getGroupFromDB(changeGroupRequest.getGroupId());
        student.setGroup(newGroup);
        Student updatedStudent = repository.save(student);
        log.info(String.format("For student id=%s1 group was changed on group id=%s2",
                studentId, changeGroupRequest.getGroupId()));
        return StudentsMapper.toStudentDto(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        getStudentById(id);
        repository.deleteById(id);
        log.info(String.format("Deleted student id=%s", id));
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
