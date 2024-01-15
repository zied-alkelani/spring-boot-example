package com.school.controller;
import com.school.model.UserEntity;
import com.school.model.UserRequest;
import com.school.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Iterable<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable (value="id") Long id ){
        return userService.getUserById(id);
    }
    @PostMapping
    public void addUser(@Valid @RequestBody UserRequest request) {
        userService.addUser(request);
    }
    @PutMapping("/{id}")
    public void updateUser(@Valid @RequestBody UserRequest userRequest , @PathVariable Long id ){
        userService.updateUser(userRequest , id);
    }
}
