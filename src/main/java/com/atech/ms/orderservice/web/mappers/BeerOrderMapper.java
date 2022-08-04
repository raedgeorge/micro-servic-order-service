package com.atech.ms.orderservice.web.mappers;

import com.atech.ms.orderservice.domain.BeerOrder;
import com.atech.ms.orderservice.web.model.BeerOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    @Mapping(target = "customerId", source = "customer.id")
    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
