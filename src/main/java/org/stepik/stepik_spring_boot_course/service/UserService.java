package org.stepik.stepik_spring_boot_course.service;

import org.stepik.stepik_spring_boot_course.model.User;

public interface UserService {

    User create(User user);

    User getCurrentUser();

}
