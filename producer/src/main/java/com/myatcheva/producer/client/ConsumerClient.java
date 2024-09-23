package com.myatcheva.producer.client;

import com.myatcheva.producer.dto.NumbersDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerClient {
    private String primeNumberSelectorUrl;

    public ConsumerClient(@Value("${consumer.resource.prime-number-selector}") String primeNumberSelectorUrl) {
        this.primeNumberSelectorUrl = primeNumberSelectorUrl;
    }

    public ResponseEntity<String> sendNumbers(NumbersDto numbersDto) {
        HttpEntity<NumbersDto> request = new HttpEntity<>(numbersDto);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(primeNumberSelectorUrl, HttpMethod.POST, request, String.class);
    }
}
