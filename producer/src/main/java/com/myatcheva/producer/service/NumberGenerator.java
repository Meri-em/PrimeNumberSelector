package com.myatcheva.producer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class NumberGenerator {

    private int maxNumbersPerTimeUnit;
    private int timeUnitMilliseconds;
    private int maxStreamSize;
    private int generatedNumberUpperBound;

    public NumberGenerator(@Value("${maxGeneratedNumbersPerTimeUnit}") int maxNumbersPerTimeUnit,
                                @Value("${timeUnitMilliseconds}") int timeUnitMilliseconds,
                                @Value("${maxStreamSize}") int maxStreamSize,
                                @Value("${generatedNumber.upperBound}") int generatedNumberUpperBound) {
        this.maxNumbersPerTimeUnit = maxNumbersPerTimeUnit;
        this.timeUnitMilliseconds = timeUnitMilliseconds;
        this.maxStreamSize = maxStreamSize;
        this.generatedNumberUpperBound = generatedNumberUpperBound;
    }

    public List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < maxStreamSize / maxNumbersPerTimeUnit; i++) {
            int numbersCount = new Random().nextInt(maxNumbersPerTimeUnit) + 1;
            for (int j = 0; j < numbersCount; j ++) {
                numbers.add(new Random().nextInt(generatedNumberUpperBound));
            }
            try {
                Thread.sleep(timeUnitMilliseconds);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return numbers;
    }

}
