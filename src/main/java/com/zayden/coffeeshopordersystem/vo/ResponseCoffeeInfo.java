package com.zayden.coffeeshopordersystem.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCoffeeInfo {
    private String coffeeUid;
    private String coffeeName;
    private Integer coffeeCost;
}
