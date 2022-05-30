package com.zayden.coffeeshopordersystem.service.coffeeorder;

import com.zayden.coffeeshopordersystem.jpa.coffeeorder.CoffeeCountEntity;
import com.zayden.coffeeshopordersystem.jpa.coffeeorder.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CoffeeOrderServiceImpl implements CoffeeOrderService{

    CoffeeOrderRepository coffeeOrderRepository;

    @Autowired
    public CoffeeOrderServiceImpl(CoffeeOrderRepository coffeeOrderRepository){
        this.coffeeOrderRepository = coffeeOrderRepository;
    }

    @Override
    public List<CoffeeCountEntity> getPopularCoffeeOrderList7DaysAgo() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        currentDateTime.
//        coffeeOrderRepository.findByCoffeeUidOrderByCoffeeUidIdDesc()
        return new String[0];
    }
}
