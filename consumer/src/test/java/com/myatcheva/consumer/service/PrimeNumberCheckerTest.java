package com.myatcheva.consumer.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrimeNumberCheckerTest {

    private PrimeNumberChecker primeNumberChecker = new PrimeNumberChecker();

    @Test
    public void isNegativeNumberPrime() {
        Assertions.assertFalse(primeNumberChecker.isPrime(-1));
    }

    @Test
    public void isZeroPrime() {
        Assertions.assertFalse(primeNumberChecker.isPrime(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 47, 89})
    public void primeNumbers(int number) {
        Assertions.assertTrue(primeNumberChecker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {121, 4, 15, 100})
    public void positiveNonPrimeNumbers(int number) {
        Assertions.assertFalse(primeNumberChecker.isPrime(number));
    }
}
