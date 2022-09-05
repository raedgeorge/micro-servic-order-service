package com.atech.brewery.model;

/**
 * @author raed abu Sa'da
 * on 28/07/2022
 */
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class CustomerDto{

    @JsonProperty("id")
    private UUID id = null;

    @JsonProperty("version")
    private Integer version = null;

    @JsonProperty("createdDate")
    private Timestamp createdDate = null;

    @JsonProperty("lastModifiedDate")
    private Timestamp lastModifiedDate = null;

    private String customerName;

}
