package com.atech.brewery.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.UUID;
/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerOrderLineDto{

    @JsonProperty("id")
    private UUID id = null;

    @JsonProperty("version")
    private Integer version = null;

    @JsonProperty("createdDate")
    private Timestamp createdDate = null;

    @JsonProperty("lastModifiedDate")
    private Timestamp lastModifiedDate = null;

    private String upc;
    private String beerName;
    private String beerStyle;
    private UUID beerId;
    private BigDecimal price;
    private Integer orderQuantity = 0;
}
