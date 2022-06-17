package com.spring.example.dto.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestProduct {

    private String name;
    private String description;
    private BigDecimal price;
}
