package com.zayden.coffeeshopordersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class KafkaCoffeeOrderDto implements Serializable {
    private Schema schema;
    private Payload payload;
}
