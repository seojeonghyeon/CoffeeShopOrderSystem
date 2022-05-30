package com.zayden.coffeeshopordersystem.jpa.coffeeorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrderEntity, Long> {
    @Query(
            value = "SELECT coffeeUid, coffeeName, coffeeCost, COUNT(coffeeUid) AS orderCount FROM coffeeorder WHERE orderDate BETWEEN date(:startDate) AND date(:endDate)+1 GROUP BY coffeeUid ORDER BY count(coffeeUid) DESC LIMIT :limitNumber",
            nativeQuery = true
    )
    List<CoffeeCountEntity> findByCoffeeUidOrderByCoffeeUidIdDesc(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("limitNumber") int limitNumber
    );
}
