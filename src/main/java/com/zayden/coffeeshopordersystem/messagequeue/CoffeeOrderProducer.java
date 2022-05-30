package com.zayden.coffeeshopordersystem.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zayden.coffeeshopordersystem.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CoffeeOrderProducer {
    private KafkaTemplate<String, String> kafkaTemplate;

    List<Field> fields = Arrays.asList(new Field("string",true,"orderUid"),
            new Field("string", true, "userUid"),
            new Field("string", true, "coffeeUid"),
            new Field("string", true, "coffeeName"),
            new Field("int32", true, "coffeeCost"));

    Schema schema = Schema.builder()
            .type("struct")
            .fields(fields)
            .optional(false)
            .name("orders")
            .build();

    @Autowired
    public CoffeeOrderProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public CoffeeOrderDto send(String topic, CoffeeOrderDto coffeeOrderDto){
        Payload payload = Payload.builder()
                .orderUid(coffeeOrderDto.getOrderUid())
                .userUid(coffeeOrderDto.getUserUid())
                .coffeeUid(coffeeOrderDto.getCoffeeUid())
                .coffeeCost(coffeeOrderDto.getCoffeeCost())
                .build();
        KafkaCoffeeOrderDto kafkaCoffeeOrderDto = new KafkaCoffeeOrderDto(schema, payload);

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";
        try{
            jsonInString = mapper.writeValueAsString(kafkaCoffeeOrderDto);
        }catch (JsonProcessingException ex){
            ex.printStackTrace();
        }

        kafkaTemplate.send(topic, jsonInString);
        log.info("Order Producer send data from the Coffee Order microservice"+kafkaCoffeeOrderDto);

        return coffeeOrderDto;
    }
}
