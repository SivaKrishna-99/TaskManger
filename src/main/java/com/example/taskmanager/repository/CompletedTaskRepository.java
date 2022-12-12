package com.example.taskmanager.repository;

import com.example.taskmanager.model.CompletedTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompletedTaskRepository extends JpaRepository<CompletedTask, Integer> {

    List<CompletedTask> findByTaskId(Integer taskId);

    List<CompletedTask> findByCompletionDate(Date completionDate);

    List<CompletedTask> findByCompletedBy(Integer completedBy);

    Optional<CompletedTask> findById(Integer id);

    List<CompletedTask> findAll();

    CompletedTask save(CompletedTask completedTask);

    void deleteById(Integer id);
}



