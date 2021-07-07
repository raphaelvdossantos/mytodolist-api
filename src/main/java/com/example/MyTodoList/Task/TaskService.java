package com.example.MyTodoList.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private Task task;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(Long taskId) { return taskRepository.findById(taskId);  }

    public Task addNewTask(Task newTask){
        newTask.setCreationDate(LocalDate.now());
       return taskRepository.save(newTask);
    }

    public void deleteTask(Long taskId) {
        boolean hasTaskWithGivenId = taskRepository.existsById(taskId);
        if(!hasTaskWithGivenId){
            throw new IllegalStateException("There's no task with id: " + taskId + ".\n" +
                    "0 tasks deleted.");
        }

        taskRepository.deleteById(taskId );
    }

    @Transactional
    public void updateTask(Long taskId,
                           String description,
                           String category,
                           LocalDate expirationDate,
                           Boolean isCompleted,
                           Boolean isCancelled,
                           String details) {
        boolean hasTaskWithGivenId = taskRepository.existsById(taskId);
        if(!hasTaskWithGivenId){
            throw  new IllegalStateException("There's no task with id: " + taskId + ".");
        }

        if(description !=null && description.length() > 0 && Objects.equals(task.getDescription(), description)){
            task.setDescription(description);
        }

        if(category !=null && category.length() > 0 && Objects.equals(task.getCategory(), category)){
            task.setCategory(category);
        }

        if(expirationDate !=null && Objects.equals(task.getExpirationDate(), expirationDate)){
            task.setExpirationDate(expirationDate);
        }

        if(isCompleted !=null && Objects.equals(task.getCompleted(), isCompleted)){
            task.setCompleted(isCompleted);
        }

        if(isCancelled !=null && Objects.equals(task.getCanceled(), isCancelled)){
            task.setCanceled(isCancelled);
        }

        if(details !=null && details.length() > 0 && Objects.equals(task.getDetails(), details)){
            task.setDetails(details);
        }
    }


}
