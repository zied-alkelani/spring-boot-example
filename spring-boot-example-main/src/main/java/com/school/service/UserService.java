package com.school.service;

import com.school.mappers.UserMapper;
import com.school.model.UserEntity;
import com.school.model.UserRequest;
import com.school.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository ;
    private final UserMapper mapper;
    public UserService(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public Iterable<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }
    public UserEntity getUserById(Long id ){
            return userRepository.getReferenceById(id);
    }
    public void addUser( UserRequest request) {
        UserEntity user = mapper.mapEntity(request);
        userRepository.save(user);
    }
    public void updateUser( UserRequest userRequest ,  Long id ){
        UserEntity user = userRepository.findById(id).orElseThrow(()  -> new RuntimeException("Entity Not Found ID :"+id));
        mapper.updateEntityFromRequest(user,userRequest);
        userRepository.save(user);
    }
}
