package com.crud.tasks;

import com.crud.tasks.weightAverage.WeightAverage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

//@SpringBootApplication
public class TasksApplication {

    public static void main(String[] args) {
//		SpringApplication.run(TasksApplication.class, args);
        List<Integer> marks = Arrays.asList(3, 1, 1, 5, 6, 4);
        List<Integer> weights = Arrays.asList(4, 6, 8, 4, 4, 10);
        WeightAverage weightAverage = new WeightAverage(weights, marks);
        try {
            double calculatedAvarage = weightAverage.weightAverage();
            DecimalFormat dfFormat = new DecimalFormat("#.##");
            System.out.println(dfFormat.format(calculatedAvarage));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
