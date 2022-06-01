package com.zayden.coffeeshopordersystem.jpa.coffeepoint;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="coffeepoint")
public class CoffeePointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String userUid;

    @Column(nullable = false)
    private String userToken;

    @Column(nullable = false, length = 150, unique = true)
    private String userTokenUid;

    @Column(nullable = false)
    private int userPoint;
}
