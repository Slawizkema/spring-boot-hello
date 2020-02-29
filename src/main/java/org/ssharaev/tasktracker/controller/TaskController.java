package org.ssharaev.tasktracker.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.ssharaev.tasktracker.model.Task;
import org.ssharaev.tasktracker.repository.TaskRepository;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__ ( @Autowired))
public class TaskController {
    private final TaskRepository taskRepository;

    @PostMapping("/task")
    public void newTask(@RequestBody Task task) {
        taskRepository.save(task);
        log.info("Save new task! {}", task);
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskRepository.getOne(id);
    }

    @PostMapping("task/{id}/subtask")
    public void addSubTask(@PathVariable Long id, @RequestBody Task task) {
        Task newTask = taskRepository.getOne(id);
        task.setParentTask(newTask);
        taskRepository.save(task);
        log.info("Task updated {}", task);
    }
}
