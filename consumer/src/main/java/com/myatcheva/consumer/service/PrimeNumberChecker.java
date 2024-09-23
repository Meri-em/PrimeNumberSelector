package com.myatcheva.consumer.service;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class PrimeNumberChecker {
    private static final int FIRST_PRIME_NUMBER = 2;
    private static final int FIRST_POSSIBLE_DIVISOR = 2;

    public boolean isPrime(int number) {
        if (number < FIRST_PRIME_NUMBER) {
            return false;
        }
        return IntStream.rangeClosed(FIRST_POSSIBLE_DIVISOR, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}
