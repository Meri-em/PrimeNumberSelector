package com.myatcheva.consumer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myatcheva.consumer.dto.NumbersDto;
import com.myatcheva.consumer.service.PrimeNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(controllers={PrimeNumberController.class})
public class PrimeNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrimeNumberService primeNumberService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void whenRequestPostThenOk() throws Exception {
        List<Integer> numbers = Arrays.asList(18, 104, 2, 11, 6);
        NumbersDto numbersDto = new NumbersDto("123", numbers);
        when(primeNumberService.savePrimeNumbers(numbersDto))
                .thenReturn("Prime numbers saved in: 66907942-b930-4afc-85ba-4448a6199ff8-prime-numbers.csv");
        ResultActions result = this.mockMvc.perform(
                post("/api/v1/prime-number-selector")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(numbersDto)));
        result.andExpect(status().isOk());
    }

    @Test
    public void whenRequestPostThenBadRequest() throws Exception {
        List<Integer> numbers = Arrays.asList(18, 104, 2, 11, 6);
        when(primeNumberService.savePrimeNumbers(any()))
                .thenReturn("Prime numbers saved in: 123-prime-numbers.csv");
        ResultActions result = this.mockMvc.perform(
                post("/api/v1/prime-number-selector")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        result.andExpect(status().isBadRequest());
    }
}
