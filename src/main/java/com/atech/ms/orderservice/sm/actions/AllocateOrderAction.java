package com.atech.ms.orderservice.sm.actions;

import com.atech.ms.orderservice.config.JmsConfig;
import com.atech.ms.orderservice.domain.BeerOrder;
import com.atech.ms.orderservice.domain.BeerOrderEventEnum;
import com.atech.ms.orderservice.domain.BeerOrderStatusEnum;
import com.atech.ms.orderservice.repositories.BeerOrderRepository;
import com.atech.ms.orderservice.services.BeerOrderManagerImpl;
import com.atech.ms.orderservice.web.mappers.BeerOrderMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author raed abu Sa'da
 * on 19/08/2022
 */

@Slf4j
@Component
@AllArgsConstructor
public class AllocateOrderAction implements Action<BeerOrderStatusEnum, BeerOrderEventEnum> {

    private final JmsTemplate jmsTemplate;
    private final BeerOrderMapper beerOrderMapper;
    private final BeerOrderRepository beerOrderRepository;

    @Override
    public void execute(StateContext<BeerOrderStatusEnum, BeerOrderEventEnum> stateContext) {

        String beerOrderId = (String) stateContext.getMessage().getHeaders().get(BeerOrderManagerImpl.ORDER_ID_HEADER);
        BeerOrder beerOrder = beerOrderRepository.findOneById(UUID.fromString(beerOrderId));

        jmsTemplate.convertAndSend(JmsConfig.ALLOCATE_ORDER_QUEUE,
                beerOrderMapper.beerOrderToDto(beerOrder));

        log.debug("Send Allocation Request for Order Id : " + beerOrderId);
    }
}
