package org.ssharaev.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssharaev.tasktracker.model.TaskList;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Long> {
}
