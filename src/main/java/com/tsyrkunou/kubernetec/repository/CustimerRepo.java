package com.tsyrkunou.kubernetec.repository;

import com.tsyrkunou.kubernetec.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustimerRepo extends JpaRepository <Customer, Integer>, JpaSpecificationExecutor <Customer> {
}
