package com.zayden.coffeeshopordersystem.jpa.coffeepoint;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CoffeePointRepository extends CrudRepository<CoffeePointEntity, Long> {
    Optional<CoffeePointEntity> findByUserUid(String userUid);
}
