package com.tsyrkunou.kubernetec.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderReuast {
    private String customerName;
    private String orderName;
    private BigDecimal customerBalance;
    private BigDecimal orderCoast;
}
