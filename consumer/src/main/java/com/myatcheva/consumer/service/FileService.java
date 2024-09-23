package com.myatcheva.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class FileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);
    private static final String PRIME_NUMBERS_FILE_EXTENSION = ".csv";
    private static final String PRIME_NUMBERS_FILE_SUFFIX = "-prime-numbers";
    private static final String DELIMITER = ",";
    private static final String PRIME_NUMBERS_FOLDER = "output";

    public String savePrimeNumbersInFile(String fileId, List<Integer> primeNumbers) {
        String fileName = new StringBuilder()
                .append(fileId)
                .append(PRIME_NUMBERS_FILE_SUFFIX)
                .append(PRIME_NUMBERS_FILE_EXTENSION)
                .toString();
        File folder = new File(PRIME_NUMBERS_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }
        try (FileWriter fileWriter = new FileWriter(new File(PRIME_NUMBERS_FOLDER, fileName))) {
            String content = primeNumbers.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(DELIMITER));
            fileWriter.write(content);
            return fileName;
        } catch (IOException e) {
            LOGGER.error("Error while writing prime numbers in file: {}", fileName);
            throw new RuntimeException(e);
        }
    }
}
