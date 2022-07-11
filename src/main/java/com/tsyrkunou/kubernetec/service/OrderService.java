package com.tsyrkunou.kubernetec.service;

import com.tsyrkunou.kubernetec.exceptionhandlers.MyAppException;
import com.tsyrkunou.kubernetec.model.Customer;
import com.tsyrkunou.kubernetec.model.Order;
import com.tsyrkunou.kubernetec.model.OrderReuast;
import com.tsyrkunou.kubernetec.repository.OrdersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrdersRepo ordersRepo;
    private final JpaSpecificationBuilder jpaSpecificationBuilder;
    private final CustomerService customerService;

    public Order createOrder (OrderReuast orderReuast){
        Customer customer = Customer.builder()
                .balance(orderReuast.getCustomerBalance())
                .name(orderReuast.getCustomerName())
                .build();
        Order orderNotPersist = Order.builder()
                .name(orderReuast.getOrderName())
                .coast(orderReuast.getOrderCoast())
                .build();
        customer.addOder(orderNotPersist);
        Customer customer1 = customerService.saveCustomer(customer);


        return customer1.getOrders().stream().filter(order -> order.getName().equals(orderNotPersist.getName())).findFirst().orElseThrow();
    }


    public Order saveOrder (Order order) {
      return ordersRepo.save(order);
    }

    public List <Order> getAll () {
        return ordersRepo.findAll();
    }

    public Order getOrderById (Long id) {
        return ordersRepo.findById(id).orElseThrow(()-> new MyAppException("Id not exist"));
    }

    public Collection<Order> getLessThen (BigDecimal bigDecimal) {
        Specification<Order> allOrderLessCoast = jpaSpecificationBuilder.getAllOrderLessCoast(bigDecimal);
        return ordersRepo.findAll(allOrderLessCoast);
    }
}
