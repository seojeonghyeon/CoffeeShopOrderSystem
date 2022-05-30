package com.zayden.coffeeshopordersystem.jpa.coffeeorder;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

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
    private Integer coffeeCost;

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value="CURRENT_TIMESTAMP")
    private Date orderDate;
}
