package org.stepik.stepik_spring_boot_course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.stepik.stepik_spring_boot_course.model.Task;
import org.stepik.stepik_spring_boot_course.service.TaskService;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public Task create(@RequestBody Task task) {
        return taskService.create(task);
    }

    @GetMapping("/tasks")
    public Iterable<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id,
                           @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PatchMapping("/tasks/{id}")
    public void markTaskAsDone(@PathVariable Long id,
                            @RequestBody Task task) {
        if (task.isDone()) {
            taskService.markTaskAsDone(id);
        }
    }

    @PatchMapping("/tasks/{id}:mark-as-done")
    public void markTaskAsDone(@PathVariable Long id) {
        taskService.markTaskAsDone(id);
    }

}
