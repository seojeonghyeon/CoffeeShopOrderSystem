package com.zayden.coffeeshopordersystem.jpa.coffeeorder;

import lombok.Data;

@Data
public class CoffeeCountEntity {
    private String coffeeUid;
    private String coffeeName;
    private Integer coffeeCost;
    private Integer orderCount;
}
