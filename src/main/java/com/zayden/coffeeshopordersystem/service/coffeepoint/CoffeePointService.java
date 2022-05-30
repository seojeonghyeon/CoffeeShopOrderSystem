package com.zayden.coffeeshopordersystem.service.coffeepoint;

import com.zayden.coffeeshopordersystem.dto.CoffeePointDto;

public interface CoffeePointService {
    boolean chargeCoffeePointByUserUid(CoffeePointDto coffeePointDto);
}
