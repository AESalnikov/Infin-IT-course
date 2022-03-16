package org.stepik.stepik_spring_boot_course.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.stepik.stepik_spring_boot_course.model.Task;

public interface TaskService {

    Task create(Task task);

    Iterable<Task> getAllTasks();

    Task getTaskById(Long id);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);

    void markTaskAsDone(Long id);

}
