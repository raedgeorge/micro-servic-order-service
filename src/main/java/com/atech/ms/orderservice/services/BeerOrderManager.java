package com.atech.ms.orderservice.services;

import com.atech.ms.orderservice.domain.BeerOrder;

import java.util.UUID;

/**
 * @author raed abu Sa'da
 * on 12/08/2022
 */
public interface BeerOrderManager {

    BeerOrder newBeerOrder(BeerOrder beerOrder);

    void processValidationResult(UUID beerOrderId, Boolean valid);
}
