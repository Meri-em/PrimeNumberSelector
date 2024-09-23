package com.myatcheva.consumer.service;

import com.myatcheva.consumer.dto.NumbersDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrimeNumberService {

    private PrimeNumberChecker primeNumberChecker;
    private FileService fileService;

    public PrimeNumberService(PrimeNumberChecker primeNumberChecker,
                              FileService fileService) {
        this.primeNumberChecker = primeNumberChecker;
        this.fileService = fileService;
    }

    public String savePrimeNumbers(NumbersDto numbersDto) {
        List<Integer> primeNumbers = numbersDto.getNumbers().stream()
                .filter(primeNumberChecker::isPrime)
                .toList();
        return fileService.savePrimeNumbersInFile(numbersDto.getId(), primeNumbers);
    }
}
