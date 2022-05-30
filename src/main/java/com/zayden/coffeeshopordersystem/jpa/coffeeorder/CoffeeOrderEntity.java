package com.zayden.coffeeshopordersystem.jpa.coffeeorder;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="coffeeorder")
public class CoffeeOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120, unique = true)
    private String orderUid;

    @Column(nullable = false)
    private String userUid;

    @Column(nullable = false)
    private String coffeeUid;

    @Column(nullable = false)
    private String coffeeName;

    @Column(nullable = false)
    private Integer coffeeCost;

    @Column(nullable = false, updatable = false, insertable = false)
    private LocalDate orderDate;
}
