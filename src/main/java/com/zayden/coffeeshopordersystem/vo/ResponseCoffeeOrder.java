package com.zayden.coffeeshopordersystem.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCoffeeOrder {
    private String userUid;
    private String coffeeUid;
    private Integer coffeeCost;
}
