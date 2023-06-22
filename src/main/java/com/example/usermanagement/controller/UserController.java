package com.example.usermanagement.controller;

import com.example.usermanagement.model.User;
import com.example.usermanagement.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "User added successfully";
    }

    @GetMapping("/getUser/{userId}")
    public String getUser(@PathVariable Long userId) {
        User userById = userService.getUserById(userId);
        if(userById==null){
            return "user with given id is not not present in database";
        }
        return userById.toString();
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateUserInfo/{userId}")
    public String updateUserInfo(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId,user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
