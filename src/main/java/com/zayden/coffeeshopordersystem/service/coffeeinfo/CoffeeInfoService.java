package com.zayden.coffeeshopordersystem.service.coffeeinfo;

import com.zayden.coffeeshopordersystem.jpa.coffeeinfo.CoffeeInfoEntity;

public interface CoffeeInfoService {
    Iterable<CoffeeInfoEntity> getCoffeeInfoListAll();
}
