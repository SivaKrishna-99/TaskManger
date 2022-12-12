package com.example.taskmanager.repository;

import com.example.taskmanager.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer> {

    List<Tasks> findByUserId(int userId);

    List<Tasks> findByCompleted(boolean completed);

    List<Tasks> findByDueDate(Date dueDate);

    List<Tasks> findByUserIdAndCompleted(int userId, boolean b);

    List<Tasks> findByUserIdAndDueDateLessThanEqualAndCompleted(int userId, Date date, boolean b);
}


