package com.tsyrkunou.kubernetec.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tsyrkunou.kubernetec.model.Customer;
import com.tsyrkunou.kubernetec.model.CustomerDTO;
import com.tsyrkunou.kubernetec.model.CustomerRequst;
import com.tsyrkunou.kubernetec.model.Order;
import com.tsyrkunou.kubernetec.model.OrderReuast;
import com.tsyrkunou.kubernetec.service.CustomerService;
import com.tsyrkunou.kubernetec.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class Controller {
    private final OrderService orderService;
    private final CustomerService customerService;

    @GetMapping("/getall")
    public ResponseEntity <?> getAllOrders () {
        return ResponseEntity.of(Optional.ofNullable(orderService.getAll()));
    }

    @GetMapping("/getdto")
    public ResponseEntity <CustomerDTO> getCustomerDto (@RequestParam Integer id) {
        return ResponseEntity.of(customerService.getCustomerDto(id));
    }

    @PostMapping("/saveorder")
    public ResponseEntity <?> saveOrder (@RequestBody Order order) {
        return ResponseEntity.of(Optional.ofNullable(orderService.saveOrder(order)));
    }

    @PostMapping("/createorder")
    public ResponseEntity <?> createOrder (@RequestBody OrderReuast orderReuast) {
        return ResponseEntity.of(Optional.ofNullable(orderService.createOrder(orderReuast)));
    }

    @PostMapping("/requestcreatecustomer")
    public ResponseEntity <?> createCustomerRequest (@RequestBody CustomerRequst customerRequst) {
        return ResponseEntity.of(Optional.ofNullable(customerService.createCustomer(customerRequst)));
    }
    @PostMapping("/createcustomer")
    public ResponseEntity <?> createOrder (@RequestBody Customer customer) {
        return ResponseEntity.of(Optional.ofNullable(customerService.saveCustomer(customer)));
    }

    @GetMapping("/getorder")
    public ResponseEntity <?> getOrder (@RequestParam Long id) {
        return ResponseEntity.of(Optional.of(orderService.getOrderById(id)));
    }

    @GetMapping("/getcustomerbyorderid")
    public ResponseEntity <?> getCustomerByOrderId (@RequestParam Long id) {
        return ResponseEntity.of(Optional.of(customerService.getCustomerByOrderId(Math.toIntExact(id))));
    }

    @GetMapping("/getless")
    public ResponseEntity <?> getOrder (@RequestParam BigDecimal bigDecimal) {
        return ResponseEntity.of(Optional.of(orderService.getLessThen(bigDecimal)));
    }
}
