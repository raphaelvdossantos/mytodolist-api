package com.example.MyTodoList.Task;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="Task")
@Table
public class Task {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private String description;
    private String category;
    private LocalDate creationDate;
    private LocalDate expirationDate;
    private Boolean isCompleted;
    private Boolean isCanceled;
    private String details;

    public Task(){}

    public Task(Long id,
                String description,
                String category,
                LocalDate creationDate,
                LocalDate expirationDate,
                String details) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.details = details;
    }

    public Task(String description,
                String category,
                LocalDate creationDate,
                LocalDate expirationDate,
                String details) {
        this.description = description;
        this.category = category;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.details = details;
    }

    public Task(Long id,
                String description,
                String category,
                LocalDate creationDate,
                LocalDate expirationDate,
                Boolean isCompleted,
                Boolean isCanceled,
                String details) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.isCompleted = isCompleted;
        this.isCanceled = isCanceled;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public Boolean getCanceled() {
        return isCanceled;
    }

    public void setCanceled(Boolean canceled) {
        isCanceled = canceled;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", creationDate=" + creationDate +
                ", expirationDate=" + expirationDate +
                ", isCompleted=" + isCompleted +
                ", isCanceled=" + isCanceled +
                ", details='" + details + '\'' +
                '}';
    }
}
