package com.dl.tacoloco.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "TACO_ORDER")
public class TacoOrder {

    @Id
    @Column
    @GeneratedValue
    UUID orderId;

    @Column 
    String customerId;

    @Column
    BigDecimal orderTotal;

}
