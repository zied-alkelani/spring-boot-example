package com.school.service;

import com.school.mappers.UserMapper;
import com.school.model.UserEntity;
import com.school.model.UserRequest;
import com.school.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceTest {
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository, userMapper);
    }
    @Test
    void addUser() {
        UserRequest request = new UserRequest();
        request.setEmail("zied@gmail.com");
        request.setFirstName("zied");
        request.setSecondName("Khaled");
        request.setLastName("Kaylani");
        request.setSchoolName("School");
        request.setPassword("password");
        UserEntity userEntity = new UserEntity();
        when(userMapper.mapEntity(request)).thenReturn(userEntity);
        userService.addUser(request);
        verify(userMapper).mapEntity(request);
        verify(userRepository).save(userEntity);
    }

}