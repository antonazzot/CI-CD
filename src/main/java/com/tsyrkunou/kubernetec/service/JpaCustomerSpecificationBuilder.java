package com.tsyrkunou.kubernetec.service;

import com.tsyrkunou.kubernetec.model.Order;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class JpaCustomerSpecificationBuilder {
    public Specification<Order> getAllOrderLessCoast (BigDecimal bigDecimal) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.lessThan(root.get(Order.Fields.coast), bigDecimal);
        });
    }
}
