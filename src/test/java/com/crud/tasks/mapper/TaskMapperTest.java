package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {
    @Autowired
    private TaskMapper taskMapper;
    //given
    @Test
    void testMapToTaskDtoFromTask(){
        //given
        Task task = new Task(20l,"Title 1","zadanie pierwsze");
        //when
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //then
        assertNotNull(taskDto);
        assertEquals("Title 1", taskDto.getTitle());
        assertEquals("zadanie pierwsze",taskDto.getContent());
        assertTrue(taskDto instanceof TaskDto);
    }


}