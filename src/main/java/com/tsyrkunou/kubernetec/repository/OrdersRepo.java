package com.tsyrkunou.kubernetec.repository;

import com.tsyrkunou.kubernetec.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrdersRepo extends JpaRepository <Order, Long>, JpaSpecificationExecutor <Order> {
}
