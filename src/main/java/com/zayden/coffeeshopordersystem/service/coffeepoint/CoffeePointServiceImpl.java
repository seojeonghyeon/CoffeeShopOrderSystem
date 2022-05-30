package com.zayden.coffeeshopordersystem.service.coffeepoint;

import com.zayden.coffeeshopordersystem.dto.CoffeePointDto;
import com.zayden.coffeeshopordersystem.jpa.coffeepoint.CoffeePointEntity;
import com.zayden.coffeeshopordersystem.jpa.coffeepoint.CoffeePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoffeePointServiceImpl implements CoffeePointService{

    CoffeePointRepository coffeePointRepository;

    @Autowired
    public CoffeePointServiceImpl(CoffeePointRepository coffeePointRepository){
        this.coffeePointRepository = coffeePointRepository;
    }

    @Override
    public boolean chargeCoffeePointByUserUid(CoffeePointDto coffeePointDto) {
        Optional<CoffeePointEntity> optionalCoffeePointEntity = coffeePointRepository.findByUserUid(coffeePointDto.getUserUid());
        if(!optionalCoffeePointEntity.isPresent()) return false;
        optionalCoffeePointEntity.ifPresent(selectUser -> {
            selectUser.setUserPoint(selectUser.getUserPoint()+coffeePointDto.getUserPoint());
            coffeePointRepository.save(selectUser);
        });
        return true;
    }
}
