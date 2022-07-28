package com.atech.ms.orderservice.repositories;

import com.atech.ms.orderservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    List<Customer> findAllByCustomerNameLike(String username);
}
