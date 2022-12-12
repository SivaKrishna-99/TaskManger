package com.example.taskmanager.api;

import com.example.taskmanager.model.Tasks;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/createTask")
    public Tasks createTask(@RequestBody Tasks tasks ){
        return taskRepository.save(tasks);
    }

    @GetMapping("/{userId}")
    public List<Tasks> getTasksByUser(@PathVariable int userId) {
        System.out.println(userId);
        System.out.println(taskRepository.findByUserId(userId));
        return taskRepository.findByUserId(userId);
    }

    @GetMapping("/completed/{userId}")
    public List<Tasks> getCompletedTasksByUser(@PathVariable int userId) {
        return taskRepository.findByUserIdAndCompleted(userId, true);
    }
    @GetMapping("/due/{userId}")
    public List<Tasks> getDueTasksByUser(@PathVariable int userId) {
        return taskRepository.findByUserIdAndDueDateLessThanEqualAndCompleted(userId, new Date(), false);
    }


    @PostMapping("/updateTasks")
    public Tasks updateTask(@RequestBody Tasks tasks){
        Tasks existingTask = taskRepository.findById(tasks.getId()).orElse(null);
        if(existingTask != null){
            existingTask.setName(tasks.getName());
            existingTask.setDueDate(tasks.getDueDate());
            existingTask.setPriority(tasks.getPriority());
            existingTask.setCompleted(tasks.isCompleted());
            existingTask.setNotes(tasks.getNotes());
            existingTask.setAttachments(tasks.getAttachments());
            return taskRepository.save(existingTask);
        }else{
            return null;
        }
    }

    @DeleteMapping(path="{taskId}")
    public void deleteTask(@PathVariable int taskId){
        taskRepository.deleteById(taskId);
    }

}
