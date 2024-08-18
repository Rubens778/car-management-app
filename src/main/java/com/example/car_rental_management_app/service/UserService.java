package com.example.car_rental_management_app.service;

import com.example.car_rental_management_app.entities.UserEntity;
import com.example.car_rental_management_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired UserRepository userRepository;
    public UserEntity saveUser(UserEntity user){
        //Method to create user.
        return userRepository.save(user);
    }
    public Optional<UserEntity> findById(Long userId){
        return userRepository.findById(userId);
    }
    public UserEntity updateUser(UserEntity user, Long userId){
        Optional<UserEntity>userEntity=userRepository.findById(userId);

        if (userEntity.isPresent()){
            UserEntity updatedUser = userEntity.get();
            updatedUser.setName(user.getName());
            updatedUser.setLastname(user.getLastname());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setAge(user.getAge());
            updatedUser.setRole(user.getRole());
            return userRepository.saveAndFlush(updatedUser);
        }
        return null;
    }
}
