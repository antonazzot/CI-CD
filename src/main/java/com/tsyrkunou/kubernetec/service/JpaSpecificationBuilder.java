package com.tsyrkunou.kubernetec.service;

import com.tsyrkunou.kubernetec.model.Customer;
import com.tsyrkunou.kubernetec.model.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.JoinType;
import java.math.BigDecimal;
@Component
public class JpaSpecificationBuilder {
    public Specification <Order> getAllOrderLessCoast (BigDecimal bigDecimal) {
        return ((root, query, criteriaBuilder) -> {
           return criteriaBuilder.lessThan(root.get(Order.Fields.coast), bigDecimal);
        });
    }

    public Specification <Order> getOrderByName (String name) {
        return ((root, query, criteriaBuilder) -> {
           return criteriaBuilder.equal(root.get(Order.Fields.name),name);
        });
    }

    public Specification <Customer> getCustomerByOrderId (Integer orderId) {
        return ((root, query, criteriaBuilder) -> {
          return   root.joinSet(Customer.Fields.orders, JoinType.LEFT)
                    .get("customer")
                  .get("id")
//                  .get("ip")
                  .in(orderId);
        });
    }


//
//    public Specification <Order> and (Specification <Order> specification) {
//        Specification.where(specification.)
//    }
}
