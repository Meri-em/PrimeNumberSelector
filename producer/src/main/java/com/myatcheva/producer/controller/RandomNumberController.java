package com.myatcheva.producer.controller;

import com.myatcheva.producer.service.RandomNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class RandomNumberController {
    private RandomNumberService randomNumberService;

    public RandomNumberController(RandomNumberService randomNumberService) {
        this.randomNumberService = randomNumberService;
    }

    @PostMapping("/random-numbers")
    public ResponseEntity<String> sendRandomNumbers() {
        return randomNumberService.sendRandomNumbers();
    }

}
