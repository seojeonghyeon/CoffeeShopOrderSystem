package com.zayden.coffeeshopordersystem.controller;

import com.zayden.coffeeshopordersystem.dto.CoffeeOrderDto;
import com.zayden.coffeeshopordersystem.dto.CoffeePointDto;
import com.zayden.coffeeshopordersystem.jpa.coffeeinfo.CoffeeInfoEntity;
import com.zayden.coffeeshopordersystem.jpa.coffeeorder.CoffeeCountEntity;
import com.zayden.coffeeshopordersystem.jpa.coffeeorder.CoffeeOrderEntity;
import com.zayden.coffeeshopordersystem.service.coffeeinfo.CoffeeInfoService;
import com.zayden.coffeeshopordersystem.service.coffeeorder.CoffeeOrderService;
import com.zayden.coffeeshopordersystem.vo.RequestCoffeeOrder;
import com.zayden.coffeeshopordersystem.vo.ResponseCoffeeInfo;
import com.zayden.coffeeshopordersystem.vo.ResponseCoffeeOrder;
import com.zayden.coffeeshopordersystem.vo.ResponsePopularOrderList;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/coffeeorder")
public class CoffeeOrderController {

    private Environment env;
    private CoffeeInfoService coffeeInfoService;
    private CoffeeOrderService coffeeOrderService;

    @Autowired
    public CoffeeOrderController(Environment env, CoffeeInfoService coffeeInfoService, CoffeeOrderService coffeeOrderService){
        this.env = env;
        this.coffeeInfoService = coffeeInfoService;
        this.coffeeOrderService = coffeeOrderService;
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<ResponseCoffeeInfo>> getCoffeeOrderListAll(){
        log.info("Before get all coffee infomation datas");

        Iterable<CoffeeInfoEntity> coffeeInfoEntities = coffeeInfoService.getCoffeeInfoListAll();

        List<ResponseCoffeeInfo> responseCoffeeInfoList = new ArrayList<>();
        coffeeInfoEntities.forEach(v->{
            responseCoffeeInfoList.add(new ModelMapper().map(v, ResponseCoffeeInfo.class));
        });

        log.info("After get all coffee infomation datas");
        return ResponseEntity.status(HttpStatus.OK).body(responseCoffeeInfoList);
    }

    @PostMapping("/postCoffeeOrders")
    public ResponseEntity<ResponseCoffeeOrder> postCoffeeOrders(@RequestBody List<RequestCoffeeOrder> requestCoffeeOrders){
        log.info("Before post coffee orders");

        HashMap<String, List<String>> coffeePointHashMap = new HashMap<>();
        requestCoffeeOrders.forEach(v->{
            List<String> coffeeList = coffeePointHashMap.getOrDefault(v.getCoffeeUid(), new ArrayList<>());
            coffeeList.add(v.getCoffeeUid());
            coffeePointHashMap.put(v.getUserUid(), coffeeList);
        });

        //커피 값 가져오기

        //사용자 잔여 포인트 확인 후, 잔여포인트 > 커피값, 차감

        //사용자 잔여 포인트 < 커피 값, fail

        //주문 내역 저장

        //kafka로 전송
        

        log.info("After post coffee orders");
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseCoffeeOrder());
    }

    @GetMapping("/popularLists")
    public ResponseEntity<List<ResponsePopularOrderList>> getCoffeeOrderPopularLists(){
        log.info("Before get popular coffee infomation datas");

        int popularBeforeDays = Integer.parseInt(env.getProperty("popularvalue.beforedays"));
        int popularLimitNumberOfData = Integer.parseInt(env.getProperty("popularvalue.limitnumberofdata"));

        List<CoffeeCountEntity> coffeeCountEntityList = coffeeOrderService.getOrderCountInfoByBeforeDaysAndLimits(popularBeforeDays, popularLimitNumberOfData);
        List<ResponsePopularOrderList> responsePopularOrderLists = new ArrayList<>();
        coffeeCountEntityList.forEach(v->{
            responsePopularOrderLists.add(new ModelMapper().map(v, ResponsePopularOrderList.class));
        });

        log.info("Add get popular coffee infomation datas");
        return ResponseEntity.status(HttpStatus.OK).body(responsePopularOrderLists);
    }
}
