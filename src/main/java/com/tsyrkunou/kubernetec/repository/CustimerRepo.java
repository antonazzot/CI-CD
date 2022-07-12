package com.tsyrkunou.kubernetec.repository;

import com.tsyrkunou.kubernetec.model.Customer;
import com.tsyrkunou.kubernetec.model.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustimerRepo extends JpaRepository <Customer, Integer>, JpaSpecificationExecutor <Customer> {

    @Query
    (value = "select new com.tsyrkunou.kubernetec.model.CustomerDTO (c.name, c.balance) from Customer c where c.id =:id")
    Optional<CustomerDTO> findDto(Long id);
}
