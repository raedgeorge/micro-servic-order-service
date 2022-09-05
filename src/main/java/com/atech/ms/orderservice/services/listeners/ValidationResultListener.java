package com.atech.ms.orderservice.services.listeners;

import com.atech.brewery.model.events.ValidateOrderResult;
import com.atech.ms.orderservice.config.JmsConfig;
import com.atech.ms.orderservice.services.BeerOrderManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author raed abu Sa'da
 * on 19/08/2022
 */

@Slf4j
@Component
@AllArgsConstructor
public class ValidationResultListener {

    private final BeerOrderManager beerOrderManager;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_RESPONSE_QUEUE)
    public void listen(ValidateOrderResult result) {

        final UUID beerOrderId = result.getOrderId();

        log.debug("Validation result for Order Id : " + beerOrderId);

        beerOrderManager.processValidationResult(beerOrderId, result.getValid());
    }
}
