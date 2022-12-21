package com.example.taskmanager.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.taskmanager.api.UserController;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
 import org.springframework.boot.test.mock.mockito.MockBean;
 import org.springframework.http.MediaType;
 import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testFindUserById() {
        User user = userController.findUserById(1);
        assertEquals(1, user.getId());
        assertEquals("johndoe", user.getUsername());
        assertEquals("john@doe.com", user.getEmail());
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testFindByUsername() {
        User user = userController.findByUsername("johndoe");
        assertEquals(1, user.getId());
        assertEquals("johndoe", user.getUsername());
        assertEquals("john@doe.com", user.getEmail());
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testFindAllUsers() {
        List<User> users = userController.findAllUsers();
        assertEquals(2, users.size());

        User user1 = users.get(0);
        assertEquals(1, user1.getId());
        assertEquals("johndoe", user1.getUsername());
        assertEquals("john@doe.com", user1.getEmail());
        assertEquals("John Doe", user1.getName());

        User user2 = users.get(1);
        assertEquals(2, user2.getId());
        assertEquals("janedoe", user2.getUsername());
        assertEquals("jane@doe.com", user2.getEmail());
        assertEquals("Jane Doe", user2.getName());
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("test_username");
        user.setPassword("test_password");
        user.setEmail("test@email.com");
        user.setName("Test User");

        User savedUser = userController.save(user);
        assertNotNull(savedUser);
        assertEquals(user.getUsername(), savedUser.getUsername());
        assertEquals(user.getPassword(), savedUser.getPassword());
        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getName(), savedUser.getName());
    }

    @Test
    public void testSaveUser() {
        User user = new User("username", "password", "email@email.com", "John Doe");
        userController.saveUser(user);

        assertNotNull(user.getId());
        assertEquals("username", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("email@email.com", user.getEmail());
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testFindUserById() throws Exception {
        // given
        User user = new User("username", "password", "email", "name");
        user = userRepository.save(user);

        // when
        User foundUser = userController.findUserById(user.getId());

        // then
        assertEquals(user, foundUser);
    }

    @Test
    public void testFindUserByUsername() throws Exception {
        // given
        User user = new User("username", "password", "email", "name");
        user = userRepository.save(user);

        // when
        User foundUser = userController.findUserByUsername(user.getUsername());

        // then
        assertEquals(user, foundUser);
    }

    @Test
    public void testFindAllUsers() throws Exception {
        // given
        User user1 = new User("username1", "password", "email", "name");
        User user2 = new User("username2", "password", "email", "name");
        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
        List<User> expectedUsers = Arrays.asList(user1, user2);

        // when
        List<User> foundUsers = userController.findAllUsers();

        // then
        assertEquals(expectedUsers, foundUsers);
    }

//    @Test
//    public void testUpdateUser() throws Exception {
//        // given
//        User user = new User("username", "password", "email", "name");
//        user =
}





