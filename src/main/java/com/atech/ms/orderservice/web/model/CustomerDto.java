package com.atech.ms.orderservice.web.model;

/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomerDto extends BaseItem {

    @Builder
    public CustomerDto(UUID id, Integer version, OffsetDateTime createdDate, OffsetDateTime lastModifiedDate, String name) {
        super(id, version, createdDate, lastModifiedDate);
        this.name = name;
    }

    private String name;

}
