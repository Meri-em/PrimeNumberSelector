package com.myatcheva.consumer.controller;

import com.myatcheva.consumer.dto.NumbersDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myatcheva.consumer.service.PrimeNumberService;

@RestController
@RequestMapping("/api/v1")
public class PrimeNumberController {
    private PrimeNumberService primeNumberService;

    public PrimeNumberController(PrimeNumberService primeNumberService) {
        this.primeNumberService = primeNumberService;
    }

    @PostMapping("/prime-number-selector")
    public ResponseEntity<String> findPrimeNumbers(@RequestBody @NonNull NumbersDto numbersDto) {
        String fileName = primeNumberService.savePrimeNumbers(numbersDto);
        return new ResponseEntity<>("Prime numbers saved in: " + fileName, HttpStatus.OK);
    }

}
