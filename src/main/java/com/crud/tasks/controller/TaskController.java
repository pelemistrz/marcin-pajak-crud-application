package com.crud.tasks.controller;


import com.crud.tasks.TasksApplication;
import com.crud.tasks.domain.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
//    private TaskMapper taskMapper;
//    private DbService dbService;

    @GetMapping
    public List<TaskDto> getTasks(){
        return new ArrayList<>();
    }

    @GetMapping
    public TaskDto getTask(Long taskId){
        return new TaskDto(1L,"test","i will be programmer");
    }

    @DeleteMapping
    public void deleteTask(Long taskId){

    }
    @PutMapping
    public TaskDto updateTask(TaskDto taskDto){
        return new TaskDto(1L,"edited test", "I WILL BE PROGRAMMER");
    }
    @PostMapping
    public void createTask(TaskDto taskDto){

    }
}
