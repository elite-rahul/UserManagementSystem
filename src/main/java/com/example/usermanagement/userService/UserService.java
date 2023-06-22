package com.example.usermanagement.userService;

import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.addUser(user);
    }

    public User getUserById(Long userId) {
        return userRepository.getUserById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public String updateUser(Long userId, User user) {
        User user1 = userRepository.getUserById(userId);
        user1.setUserName(user.getUserName());
        user1.setName(user.getName());
        user1.setAddress(user.getAddress());
        user1.setPhoneNumber(user.getPhoneNumber());
        return "user updated successfully";
    }

    public String deleteUser(Long userId) {
        userRepository.deleteUser(userId);
        return "user deleted successfully";

    }
}
