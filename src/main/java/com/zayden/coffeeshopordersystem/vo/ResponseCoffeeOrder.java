package com.zayden.coffeeshopordersystem.vo;

import lombok.Data;

@Data
public class ResponseCoffeeOrder {
    private String userUid;
    private String coffeeUid;
    private Integer coffeeCost;
}
