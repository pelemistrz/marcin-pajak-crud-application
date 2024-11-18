package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class DbService {
    @Autowired
    private final TaskRepository repository;
    @Autowired
    private final TaskMapper taskMapper;

    public List<TaskDto> getAllTasks() {
        return taskMapper.mapToTaskDtoList(repository.findAll());
    }

    public TaskDto getTask(final Long taskId) throws TaskNotFoundException {

        return taskMapper.mapToTaskDto(repository.findById(taskId).orElseThrow(TaskNotFoundException::new));
    }

    public TaskDto saveTask(final TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        Task savedTask = repository.save(task);
         return taskMapper.mapToTaskDto(savedTask);
    }
    public void deleteTaskById(final Long taskId) {
        repository.deleteById(taskId);
    }
}
