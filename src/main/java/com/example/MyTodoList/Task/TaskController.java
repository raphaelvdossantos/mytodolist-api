package com.example.MyTodoList.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins ="http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path="api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping(path = "{taskId}")
    public Optional<Task> getTask(@PathVariable(value = "taskId") Long taskId){
        return taskService.getTask(taskId);
    }

    @PostMapping
    public Task createNewTask(@RequestBody Task newTask){
        return taskService.addNewTask(newTask);
    }

    @DeleteMapping(path="{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId){
        taskService.deleteTask(taskId);
    }

    @PutMapping(path="{taskId}")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) LocalDate expirationDate,
            @RequestParam(required = false) Boolean isCompleted,
            @RequestParam(required = false) Boolean isCancelled,
            @RequestParam(required = false) String details
            ){
        taskService.updateTask(taskId, description, category, expirationDate, isCompleted, isCancelled, details);
    }
}
