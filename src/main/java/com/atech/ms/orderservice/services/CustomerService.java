package com.atech.ms.orderservice.services;

import com.atech.brewery.model.CustomerDto;

import java.util.List;

/**
 * @author raed abu Sa'da
 * on 23/08/2022
 */
public interface CustomerService {

    List<CustomerDto> getAllCustomers();
}
