package com.atech.ms.orderservice.domain;

/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class BeerOrderLine extends BaseEntity {

    @Builder
    public BeerOrderLine(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                         BeerOrder beerOrder, UUID beerId, Integer orderQuantity,
                         Integer quantityAllocated, String upc, String beerName) {

        super(id, version, createdDate, lastModifiedDate);
        this.beerOrder = beerOrder;
        this.beerId = beerId;
        this.orderQuantity = orderQuantity;
        this.quantityAllocated = quantityAllocated;
        this.upc = upc;
        this.beerName = beerName;
    }

    @ManyToOne
    private BeerOrder beerOrder;

    private String upc;
    private UUID beerId;
    private String beerName;
    private Integer orderQuantity = 0;
    private Integer quantityAllocated = 0;
}
