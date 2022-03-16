package org.stepik.stepik_spring_boot_course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.stepik.stepik_spring_boot_course.model.User;
import org.stepik.stepik_spring_boot_course.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public User registration(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/me")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
}
