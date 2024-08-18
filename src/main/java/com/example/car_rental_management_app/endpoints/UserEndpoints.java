package com.example.car_rental_management_app.endpoints;

import com.example.car_rental_management_app.entities.UserEntity;
import com.example.car_rental_management_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserEndpoints {
    @Autowired
    UserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        UserEntity createUser = userService.saveUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<Optional<UserEntity>>getUserById(@PathVariable Long userId){
        Optional<UserEntity> returnedUser = userService.findById(userId);
        return new ResponseEntity<>(returnedUser,HttpStatus.OK);
    }
    @PostMapping("/updateUser/{userId}")
    public ResponseEntity<UserEntity>updateUser(@RequestBody UserEntity user,@PathVariable Long userId){
        UserEntity updatedUser = userService.updateUser(user,userId);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
}
