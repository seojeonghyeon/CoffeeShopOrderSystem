package com.zayden.coffeeshopordersystem.service.coffeeorder;

import com.zayden.coffeeshopordersystem.jpa.coffeeorder.CoffeeCountEntity;

import java.util.List;

public interface CoffeeOrderService {
    List<CoffeeCountEntity> getOrderCountInfoByBeforeDaysAndLimits(int beforeDays, int limitNumberOfData);
}
