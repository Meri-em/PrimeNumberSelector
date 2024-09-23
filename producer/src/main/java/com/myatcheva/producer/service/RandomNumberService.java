package com.myatcheva.producer.service;

import com.myatcheva.producer.client.ConsumerClient;
import com.myatcheva.producer.dto.NumbersDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RandomNumberService {
    private NumberGenerator numberGenerator;
    private FileService fileService;
    private ConsumerClient consumerClient;

    private RandomNumberService(NumberGenerator numberGenerator, FileService fileService,
                                ConsumerClient consumerClient) {
        this.numberGenerator = numberGenerator;
        this.fileService = fileService;
        this.consumerClient = consumerClient;
    }

    public ResponseEntity<String> sendRandomNumbers() {
        List<Integer> numbers = numberGenerator.generateNumbers();
        String id = UUID.randomUUID().toString();
        fileService.saveRandomNumbersInFile(id, numbers);
        NumbersDto numbersDto = new NumbersDto(id, numbers);
        return consumerClient.sendNumbers(numbersDto);
    }
}
