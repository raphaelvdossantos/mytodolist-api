package com.example.MyTodoList.Task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository){
        return args-> {
            Task betterJob = new Task(
                    1L,
                    "Get a better job",
                    "Job",
                    LocalDate.now(),
                    LocalDate.of(2021, Month.DECEMBER, 01),
                    "Advance my career with more challenges in another company."
            );

            repository.saveAll(List.of(betterJob));
        };
    }
}
