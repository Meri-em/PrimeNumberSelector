package com.myatcheva.consumer.dto;

import java.util.List;

public class NumbersDto {
    private String id;
    private List<Integer> numbers;

    public NumbersDto() {}

    public NumbersDto(String id, List<Integer> numbers) {
        this.id = id;
        this.numbers = numbers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
