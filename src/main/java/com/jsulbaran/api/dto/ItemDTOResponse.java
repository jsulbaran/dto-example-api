package com.jsulbaran.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemDTOResponse {
    @JsonProperty("item_id")
    private long id;
    @JsonProperty("item_description")
    private String description;
    @JsonProperty("item_part_number")
    private String partNumber;
}
