package com.crud.tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class TasksApplication {

    public static void main(String[] args) {
        Integer[] values = {3,1,1,5,6,4};
        List<Integer> arr = Arrays.asList(values);
        System.out.println(Sort.sort(arr));

//        SpringApplication.run(TasksApplication.class, args);
    }
}
