package com.crud.tasks.controller;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
//    TasKMapper tasKMapper;
//    DbService dbService;

    @GetMapping(value = "")
    public List<TaskDto> getTasks(){
        return new ArrayList<>();
    }
    @GetMapping(value = "{taskId}")
    public TaskDto getTask(@PathVariable Long taskId){
        return new TaskDto(1L, "test title", "test content");
    }
    @DeleteMapping(value = "taskId")
    public void deleteTask(Long taskId){

    }

    @PutMapping
    public TaskDto updateTask(TaskDto taskDto){
        return new TaskDto(1L, "test edit title", "test edit content");
    }
    public void createTask(TaskDto taskDto){

    }
}
