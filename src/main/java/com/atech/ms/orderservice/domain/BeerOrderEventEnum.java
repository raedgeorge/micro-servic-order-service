package com.atech.ms.orderservice.domain;

/**
 * @author raed abu Sa'da
 * on 12/08/2022
 */
public enum BeerOrderEventEnum {

    VALIDATE_ORDER,
    VALIDATION_PASSED,
    VALIDATION_FAILED,
    ALLOCATION_SUCCESS,
    ALLOCATE_ORDER,
    ALLOCATION_NO_INVENTORY,
    ALLOCATION_FAILED,
    BEER_ORDER_PICKED_UP,
}
