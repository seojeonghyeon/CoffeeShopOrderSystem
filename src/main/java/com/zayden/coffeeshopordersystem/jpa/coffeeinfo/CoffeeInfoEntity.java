package com.zayden.coffeeshopordersystem.jpa.coffeeinfo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="coffeeinfo")
public class CoffeeInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String coffeeUid;

    @Column(nullable = false)
    private String coffeeName;

    @Column(nullable = false)
    private Integer coffeeCost;
}
