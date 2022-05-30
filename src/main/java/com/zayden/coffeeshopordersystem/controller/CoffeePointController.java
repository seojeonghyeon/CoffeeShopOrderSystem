package com.zayden.coffeeshopordersystem.controller;

import com.zayden.coffeeshopordersystem.dto.CoffeePointDto;
import com.zayden.coffeeshopordersystem.service.coffeepoint.CoffeePointService;
import com.zayden.coffeeshopordersystem.vo.RequestChargeCoffeePoint;
import com.zayden.coffeeshopordersystem.vo.RequestCoffeeOrder;
import com.zayden.coffeeshopordersystem.vo.ResponseChargeCoffeePoint;
import com.zayden.coffeeshopordersystem.vo.ResponseCoffeeInfo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/coffeepoint")
public class CoffeePointController {

    private Environment env;
    private CoffeePointService coffeePointService;

    @Autowired
    public CoffeePointController(Environment env, CoffeePointService coffeePointService){
        this.env =env;
        this.coffeePointService = coffeePointService;
    }

    @PostMapping("/chargePoint")
    public ResponseEntity<ResponseChargeCoffeePoint> postCoffeeOrders(@RequestBody RequestChargeCoffeePoint requestChargeCoffeePoint){
        log.info("Before charge coffee points");

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CoffeePointDto coffeePointDto = mapper.map(requestChargeCoffeePoint, CoffeePointDto.class);

        if(!coffeePointService.chargeCoffeePointByUserUid(coffeePointDto))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseChargeCoffeePoint());

        log.info("After charge coffee points");
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseChargeCoffeePoint());
    }
}
