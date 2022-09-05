package com.atech.ms.orderservice.services;

import com.atech.brewery.model.CustomerDto;
import com.atech.ms.orderservice.repositories.CustomerRepository;
import com.atech.ms.orderservice.web.mappers.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author raed abu Sa'da
 * on 23/08/2022
 */

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> customerMapper.toDto(customer))
                .collect(Collectors.toList());
    }
}
