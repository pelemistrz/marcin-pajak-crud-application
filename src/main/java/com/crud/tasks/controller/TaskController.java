package com.crud.tasks.controller;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.service.DbService;
import com.crud.tasks.mapper.TaskMapper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TaskController {
    @Autowired
    TaskMapper tasKMapper;
    @Autowired
    DbService service;

    @GetMapping(value = "")
    public List<TaskDto> getTasks(){
         List<Task> tasks = service.getAllTasks();
        return tasKMapper.mapToTaskDtoList(tasks);
    }
    @GetMapping(value = "{taskId}")
    public TaskDto getTask(@PathVariable Long taskId){
        Task foundTask = service.findById(taskId);
        return tasKMapper.mapToTaskDto(foundTask);
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
