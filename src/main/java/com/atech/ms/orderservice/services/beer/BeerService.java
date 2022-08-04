package com.atech.ms.orderservice.services.beer;

import java.util.UUID;

/**
 * @author raed abu Sa'da
 * on 01/08/2022
 */
public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto getBeerByUpc(String upc);
}
