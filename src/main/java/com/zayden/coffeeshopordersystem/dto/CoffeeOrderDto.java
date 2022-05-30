package com.zayden.coffeeshopordersystem.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CoffeeOrderDto {
    private String orderUid;
    private String userUid;
    private String coffeeUid;
    private String coffeeName;
    private Integer coffeeCost;
    private LocalDate orderDate;
}
