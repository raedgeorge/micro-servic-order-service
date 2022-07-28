package com.atech.ms.orderservice.web.mappers;

import com.atech.ms.orderservice.domain.BeerOrderLine;
import com.atech.ms.orderservice.web.model.BeerOrderLineDto;
import org.mapstruct.Mapper;

/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */

@Mapper(uses = DateMapper.class)
public interface BeerOrderLineMapper {

    BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line);

    BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto);
}
