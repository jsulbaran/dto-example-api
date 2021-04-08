package com.jsulbaran.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class ItemDTORequest {

    @JsonProperty("item_description")
    @NotNull
    @Size(min = 2, max = 10, message = "2 to 10 characters allowed for description")
    private String description;

    @JsonProperty("item_part_number")
    @Pattern(regexp = "^[0-9]{1,6}$", message = "Only numeric values of 1 to 6 digits are allowed")
    @NotNull
    private String partNumber;
}
