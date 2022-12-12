package com.example.taskmanager.api;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // handle POST requests to /users for registering a new user
    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // handle GET requests to /users/{username} for retrieving a user
    @GetMapping(path = "/{usename}")
    public User getUser(String username) {
        return userRepository.findByUsername(username);

    }

    // handle PUT requests to /users/{username} for updating a user
    @PostMapping(path = "/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        User userToBeUpdated = userRepository.findByUsername(username);
        if (userToBeUpdated != null){
            userToBeUpdated.setName(user.getName());
            userToBeUpdated.setEmail(user.getEmail());
            userToBeUpdated.setPassword(user.getPassword());
            return userRepository.save(userToBeUpdated);
        }else{
            return null;
        }
    }

    // handle DELETE requests to /users/{username} for deleting a user
    @DeleteMapping(path = "/{username}")
    public void deleteUser(@PathVariable String username) {
        // delete the user from the database
        userRepository.deleteByUsername(username);
    }
}

