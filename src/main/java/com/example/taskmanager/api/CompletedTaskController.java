package com.example.taskmanager.api;

import com.example.taskmanager.model.CompletedTask;
import com.example.taskmanager.repository.CompletedTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/completedtasks")
public class CompletedTaskController {
    @Autowired
    private CompletedTaskRepository completedTaskRepository;

    @GetMapping(path="/{id}")
    public Optional<CompletedTask> getCompletedTask(@PathVariable int id){
        return completedTaskRepository.findById(id);
    }

    @PostMapping(path="/")
    public CompletedTask addCompletedTask(@RequestBody CompletedTask completedTask){
        return completedTaskRepository.save(completedTask);
    }
    @PutMapping("/{id}")
    public CompletedTask updateCompletedTask(@PathVariable int id, @RequestBody CompletedTask completedTask) {
        completedTask.setId(id);
        return completedTaskRepository.save(completedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteCompletedTask(@PathVariable int id) {
        List<CompletedTask> completedTasks = completedTaskRepository.findByTaskId(id);
        completedTaskRepository.deleteAll(completedTasks);
    }
}
