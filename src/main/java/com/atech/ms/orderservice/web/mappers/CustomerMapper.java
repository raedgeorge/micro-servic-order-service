package com.atech.ms.orderservice.web.mappers;

import com.atech.brewery.model.CustomerDto;
import com.atech.ms.orderservice.domain.Customer;
import org.mapstruct.Mapper;

/**
 * @author raed abu Sa'da
 * on 23/08/2022
 */

@Mapper
public interface CustomerMapper {

    Customer toEntity(CustomerDto customerDto);

    CustomerDto toDto(Customer customer);
}
