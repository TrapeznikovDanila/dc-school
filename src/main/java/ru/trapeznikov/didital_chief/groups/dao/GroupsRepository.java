package ru.trapeznikov.didital_chief.groups.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trapeznikov.didital_chief.groups.model.Group;

import java.util.List;

public interface GroupsRepository extends JpaRepository<Group, Long> {
    List<Group> findByStudentsAge(int studentsAge);
}
