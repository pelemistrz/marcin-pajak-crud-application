package com.crud.tasks.weightAverage;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.round;

public class WeightAverage {
    List<Integer> weights;
    List<Integer> marks;

    public WeightAverage(List<Integer> weights, List<Integer> marks) {
        this.weights = weights;
        this.marks = marks;
    }

    public double weightAverage() throws ExceptionWeightAverage {
        if(weights.size() != marks.size() || weights.isEmpty() || marks.isEmpty()){
            throw new ExceptionWeightAverage("You have different numbers of weights and marks");
        }
        List<Integer> checkedWeights = weights.stream()
                .filter(i -> i>=1 && i<=10)
                .collect(Collectors.toList());
        if(checkedWeights.size() != weights.size()){
            throw new ExceptionWeightAverage("There are weight out of range. Weight should be beetween 1-10");
        }
        List<Integer> checkedMarks = marks.stream()
                .filter(m -> m>=1 && m<=6)
                .collect(Collectors.toList());
        if(checkedMarks.size() != marks.size()){
            throw new ExceptionWeightAverage("There are mark out of range. Mark should be beetween 1-6");
        }
        Integer sumOfWeightMultiplyMarks = IntStream.range(0,weights.size())
                        .map(i->weights.get(i) * marks.get(i))
                                .sum();
        Integer sumOfWeights = weights.stream()
                .mapToInt(i->i)
                .sum();
        double average = (double) sumOfWeightMultiplyMarks  /sumOfWeights ;

        return average;
    }



}
