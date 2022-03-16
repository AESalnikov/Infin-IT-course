package org.stepik.stepik_spring_boot_course.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.stepik.stepik_spring_boot_course.model.User;
import org.stepik.stepik_spring_boot_course.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void create() {
        User user = new User();
        user.setPassword("Qwerty123!");
        String encodedPassword = "jf2w0jisdlfnweijdf0qjiedsolkfmwepofdjmsd";
        Mockito.doReturn(encodedPassword).when(passwordEncoder).encode(user.getPassword());
        userService.create(user);
        Mockito.verify(userRepository).save(user);
        Assertions.assertEquals(encodedPassword, user.getPassword());
    }
}