package com.zayden.coffeeshopordersystem.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePopularOrderList {
    private String coffeeUid;
    private String coffeeName;
    private Integer coffeeCost;
    private Integer orderCount;
}
