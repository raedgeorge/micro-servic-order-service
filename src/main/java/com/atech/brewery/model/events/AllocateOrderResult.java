package com.atech.brewery.model.events;

import com.atech.brewery.model.BeerOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author raed abu Sa'da
 * on 19/08/2022
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllocateOrderResult {

    private BeerOrderDto beerOrderDto;
    private Boolean allocationError = false;
    private Boolean pendingInventory = false;

}
