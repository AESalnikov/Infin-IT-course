package org.stepik.stepik_spring_boot_course.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.stepik.stepik_spring_boot_course.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByLogin(String login);

}
