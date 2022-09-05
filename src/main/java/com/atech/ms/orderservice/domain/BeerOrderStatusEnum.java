package com.atech.ms.orderservice.domain;

/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */
public enum BeerOrderStatusEnum {

    NEW,
    VALIDATED,
    VALIDATION_PENDING,
    ALLOCATION_PENDING,
    ALLOCATED,
    ALLOCATED_EXCEPTION,
    VALIDATION_EXCEPTION,
    PENDING_INVENTORY,
    READY,
    PICKED_UP,
    DELIVERED,
    DELIVERY_EXCEPTION
}
