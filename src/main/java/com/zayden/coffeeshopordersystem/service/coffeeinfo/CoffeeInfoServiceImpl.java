package com.zayden.coffeeshopordersystem.service.coffeeinfo;

import com.zayden.coffeeshopordersystem.jpa.coffeeinfo.CoffeeInfoEntity;
import com.zayden.coffeeshopordersystem.jpa.coffeeinfo.CoffeeInfoRepository;
import com.zayden.coffeeshopordersystem.vo.ResponseCoffeeInfo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeInfoServiceImpl implements CoffeeInfoService{

    CoffeeInfoRepository coffeeInfoRepository;

    @Autowired
    public CoffeeInfoServiceImpl(CoffeeInfoRepository coffeeInfoRepository){
        this.coffeeInfoRepository = coffeeInfoRepository;
    }

    @Override
    public Iterable<CoffeeInfoEntity> getCoffeeInfoListAll() {
        return coffeeInfoRepository.findAll();
    }

}
