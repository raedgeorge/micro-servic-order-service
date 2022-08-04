package com.atech.ms.orderservice.services.beer;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author raed abu Sa'da
 * on 01/08/2022
 */
@Getter
@Setter
public class BeerDto {

    private String upc;
    private String beerName;
    private UUID beerId;
    private BigDecimal price;
    private String beerStyle;

}
