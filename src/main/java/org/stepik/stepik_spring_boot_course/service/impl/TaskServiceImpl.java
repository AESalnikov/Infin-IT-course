package org.stepik.stepik_spring_boot_course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stepik.stepik_spring_boot_course.model.Task;
import org.stepik.stepik_spring_boot_course.repository.TaskRepository;
import org.stepik.stepik_spring_boot_course.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Task create(Task task) {
        task.setUser(userService.getCurrentUser());
        return taskRepository.save(task);
    }

    @Override
    public Iterable<Task> getAllTasks() {
        return taskRepository.findAllTasksByUser(userService.getCurrentUser())
                .orElseThrow(() -> new IllegalArgumentException("tasks not found"));
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findTaskByIdAndUser(id, userService.getCurrentUser()).orElse(null);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        if (getTaskById(id) == null)
            return null;
        task.setId(id);
        return create(task);
    }

    @Override
    public void deleteTask(Long id) {
        if (getTaskById(id) != null)
            taskRepository.deleteById(id);
    }

    @Override
    public void markTaskAsDone(Long id) {
        if (getTaskById(id) != null)
            taskRepository.markAsDone(id);
    }

}
