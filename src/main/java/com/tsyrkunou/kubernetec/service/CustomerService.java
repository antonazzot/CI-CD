package com.tsyrkunou.kubernetec.service;

import com.tsyrkunou.kubernetec.model.Customer;
import com.tsyrkunou.kubernetec.model.CustomerDTO;
import com.tsyrkunou.kubernetec.model.CustomerRequst;
import com.tsyrkunou.kubernetec.repository.CustimerRepo;
import lombok.RequiredArgsConstructor;
import mapper.CustomerMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustimerRepo custimerRepo;
    private final JpaSpecificationBuilder jpaSpecificationBuilder;
    private final CustomerMapper mapper = Mappers.getMapper(CustomerMapper.class);

    public Customer saveCustomer(Customer customer) {
      return   custimerRepo.save(customer);
    }

    public  Customer getCustomer (Integer id) {
        return custimerRepo.findById(id).orElseThrow();
    }

    public Customer getCustomerByOrderId (Integer id) {
        return custimerRepo.findOne(jpaSpecificationBuilder.getCustomerByOrderId(id)).orElseThrow();
    }

    public Customer createCustomer (CustomerRequst customerRequst) {
        Customer customer = mapper.customerRequstToCustomer(customerRequst);
        return saveCustomer(customer);
    }

    public Optional<CustomerDTO> getCustomerDto(Long id) {
        return custimerRepo.findDto(id);
    }
}
