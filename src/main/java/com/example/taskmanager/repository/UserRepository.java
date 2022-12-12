package com.example.taskmanager.repository;

import com.example.taskmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    // certain methods implemented in Jparepo can be used directly by declaring and also some
    // some dynamic methods with findBy*();
    User findByUsername(String username);

    List<User> findByNameContaining(String name);

    void deleteByUsername(String username);
}


