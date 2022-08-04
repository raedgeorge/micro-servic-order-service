package com.atech.ms.orderservice.web.mappers;

import com.atech.ms.orderservice.domain.BeerOrderLine;
import com.atech.ms.orderservice.services.beer.BeerDto;
import com.atech.ms.orderservice.services.beer.BeerService;
import com.atech.ms.orderservice.web.model.BeerOrderLineDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author raed abu Sa'da
 * on 01/08/2022
 */

public abstract class BeerOrderLineDecorator implements BeerOrderLineMapper{

    private BeerOrderLineMapper mapper;
    private BeerService beerService;

    @Autowired
    public void setMapper(BeerOrderLineMapper mapper){
        this.mapper = mapper;
    }

    @Autowired
    public void setBeerService(BeerService beerService){
        this.beerService = beerService;
    }


    @Override
    public BeerOrderLineDto beerOrderLineToDto(BeerOrderLine line) {

        BeerOrderLineDto beerOrderLineDto = mapper.beerOrderLineToDto(line);

        BeerDto beerDto = beerService.getBeerByUpc(line.getUpc());

        beerOrderLineDto.setBeerName(beerDto.getBeerName());
        beerOrderLineDto.setPrice(beerDto.getPrice());
        beerOrderLineDto.setBeerStyle(beerDto.getBeerStyle());
        beerOrderLineDto.setBeerId(beerDto.getBeerId());

        return beerOrderLineDto;
    }

    @Override
    public BeerOrderLine dtoToBeerOrderLine(BeerOrderLineDto dto) {
        return mapper.dtoToBeerOrderLine(dto);
    }
}
