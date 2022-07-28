package com.atech.ms.orderservice.repositories;

import com.atech.ms.orderservice.domain.BeerOrderLine;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */
public interface BeerOrderLineRepository extends PagingAndSortingRepository<BeerOrderLine, UUID> {

}
