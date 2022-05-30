package com.zayden.coffeeshopordersystem.service.coffeeorder;

import com.zayden.coffeeshopordersystem.dto.CoffeeOrderDto;
import com.zayden.coffeeshopordersystem.jpa.coffeeorder.CoffeeCountEntity;
import com.zayden.coffeeshopordersystem.jpa.coffeeorder.CoffeeOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CoffeeOrderServiceImpl implements CoffeeOrderService{

    CoffeeOrderRepository coffeeOrderRepository;

    @Autowired
    public CoffeeOrderServiceImpl(CoffeeOrderRepository coffeeOrderRepository){
        this.coffeeOrderRepository = coffeeOrderRepository;
    }

    @Override
    public List<CoffeeCountEntity> getOrderCountInfoByBeforeDaysAndLimits(int beforeDays, int limitNumberOfData){
        LocalDate currentDate = LocalDate.now();
        return coffeeOrderRepository.findByCoffeeUidOrderByCoffeeUidIdDesc(currentDate.minusDays(beforeDays), currentDate, limitNumberOfData);
    }

    @Override
    public boolean updateCoffeeOrder(CoffeeOrderDto coffeeOrderDto) {
        return false;
    }
}
