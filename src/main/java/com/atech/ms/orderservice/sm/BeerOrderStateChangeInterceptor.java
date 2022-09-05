package com.atech.ms.orderservice.sm;

import com.atech.ms.orderservice.domain.BeerOrder;
import com.atech.ms.orderservice.domain.BeerOrderEventEnum;
import com.atech.ms.orderservice.domain.BeerOrderStatusEnum;
import com.atech.ms.orderservice.repositories.BeerOrderRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import static com.atech.ms.orderservice.services.BeerOrderManagerImpl.ORDER_ID_HEADER;

/**
 * @author raed abu Sa'da
 * on 19/08/2022
 */

@Slf4j
@Component
@AllArgsConstructor
public class BeerOrderStateChangeInterceptor extends StateMachineInterceptorAdapter<BeerOrderStatusEnum, BeerOrderEventEnum> {

    private final BeerOrderRepository beerOrderRepository;

    @Override
    public void preStateChange(State<BeerOrderStatusEnum, BeerOrderEventEnum> state,
                               Message<BeerOrderEventEnum> message, Transition<BeerOrderStatusEnum,
                               BeerOrderEventEnum> transition, StateMachine<BeerOrderStatusEnum,
                               BeerOrderEventEnum> stateMachine) {

        Optional.ofNullable(message)
                .flatMap(msg -> Optional.ofNullable((String) msg.getHeaders().getOrDefault(ORDER_ID_HEADER, " ")))
                .ifPresent(orderId -> {

                    log.debug("Saving state for order id : " + orderId + "Status : " + state.getId());

                    BeerOrder beerOrder = beerOrderRepository.getOne(UUID.fromString(orderId));
                    beerOrder.setOrderStatus(state.getId());
                    beerOrderRepository.saveAndFlush(beerOrder);
                });

    }
}
