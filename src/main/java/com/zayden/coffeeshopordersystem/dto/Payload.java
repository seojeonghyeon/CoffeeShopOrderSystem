package com.zayden.coffeeshopordersystem.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Payload {
    private String orderUid;
    private String userUid;
    private String coffeeUid;
    private String coffeeName;
    private int coffeeCost;
}
