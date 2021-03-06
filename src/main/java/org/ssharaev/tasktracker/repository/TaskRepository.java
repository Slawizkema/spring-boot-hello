package org.ssharaev.tasktracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ssharaev.tasktracker.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
