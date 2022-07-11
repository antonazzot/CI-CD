package com.tsyrkunou.kubernetec.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerRequst {
    private String customerName;
    private BigDecimal customerBalance;
}
