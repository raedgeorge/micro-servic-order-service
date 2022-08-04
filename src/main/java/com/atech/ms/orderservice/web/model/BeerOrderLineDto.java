package com.atech.ms.orderservice.web.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BeerOrderLineDto extends BaseItem {

    @Builder
    public BeerOrderLineDto(UUID id,
                            Integer version,
                            OffsetDateTime createdDate,
                            OffsetDateTime lastModifiedDate,
                            String upc,
                            String beerName,
                            UUID beerId,
                            Integer orderQuantity,
                            String beerStyle,
                            BigDecimal price) {

        super(id, version, createdDate, lastModifiedDate);
        this.upc = upc;
        this.beerName = beerName;
        this.beerId = beerId;
        this.orderQuantity = orderQuantity;
        this.beerStyle = beerStyle;
        this.price = price;
    }

    private String upc;
    private String beerName;
    private String beerStyle;
    private UUID beerId;
    private BigDecimal price;
    private Integer orderQuantity = 0;
}
