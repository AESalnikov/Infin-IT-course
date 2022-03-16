package org.stepik.stepik_spring_boot_course.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.stepik.stepik_spring_boot_course.model.Task;
import org.stepik.stepik_spring_boot_course.model.User;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    @Modifying
    @Query("UPDATE Task t SET t.done = TRUE WHERE t.id = :id")
    void markAsDone(@Param("id") Long id);

    Optional<List<Task>> findAllTasksByUser(User user);

    Optional<Task> findTaskByIdAndUser(Long id, User user);
}
