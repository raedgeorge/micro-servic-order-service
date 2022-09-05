package com.atech.ms.orderservice.sm.actions;

import com.atech.brewery.model.events.ValidateOrderRequest;
import com.atech.ms.orderservice.config.JmsConfig;
import com.atech.ms.orderservice.domain.BeerOrder;
import com.atech.ms.orderservice.domain.BeerOrderEventEnum;
import com.atech.ms.orderservice.domain.BeerOrderStatusEnum;
import com.atech.ms.orderservice.repositories.BeerOrderRepository;
import com.atech.ms.orderservice.web.mappers.BeerOrderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.atech.ms.orderservice.services.BeerOrderManagerImpl.ORDER_ID_HEADER;

/**
 * @author raed abu Sa'da
 * on 19/08/2022
 */

@Slf4j
@Component
@AllArgsConstructor
public class ValidateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

    private final BeerOrderRepository beerOrderRepository;
    private final BeerOrderMapper beerOrderMapper;
    private final JmsTemplate jmsTemplate;

    @Override
    public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> stateContext) {

        String beerOrderId = (String) stateContext.getMessage().getHeaders().get(ORDER_ID_HEADER);

        BeerOrder beerOrder = beerOrderRepository.findOneById(UUID.fromString(beerOrderId));

        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_QUEUE, ValidateOrderRequest.builder()
                .beerOrder(beerOrderMapper.beerOrderToDto(beerOrder))
                .build());

        log.debug("Sent Validation request to queue for order id : " + beerOrderId);
    }
}
