package com.atech.ms.orderservice.services;

/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */
import com.atech.ms.orderservice.web.model.BeerOrderDto;
import com.atech.ms.orderservice.web.model.BeerOrderPagedList;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface BeerOrderService {

    BeerOrderPagedList listOrders(UUID customerId, Pageable pageable);

    BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto);

    BeerOrderDto getOrderById(UUID customerId, UUID orderId);

    void pickupOrder(UUID customerId, UUID orderId);
}
