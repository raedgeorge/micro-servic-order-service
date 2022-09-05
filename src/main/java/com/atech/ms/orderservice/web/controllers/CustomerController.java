package com.atech.ms.orderservice.web.controllers;

import com.atech.brewery.model.CustomerDto;
import com.atech.ms.orderservice.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author raed abu Sa'da
 * on 23/08/2022
 */
@Slf4j
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public List<CustomerDto> getAllCustomers(@PathVariable UUID customerId){

        log.debug("get all customers");
        return customerService.getAllCustomers();
    }
}
