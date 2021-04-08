package com.jsulbaran.api.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.jsulbaran.api.model.Constants.MAXIMUM_DESCRIPTION_SIZE;
import static com.jsulbaran.api.model.Constants.MAXIMUM_PART_NUMBER_SIZE;

@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "description must be specified")
    @Size(max = MAXIMUM_DESCRIPTION_SIZE, message = "description should be maximum {max}")
    @Column(name = "item_description")
    private String description;

    @NotBlank(message = "partNumber must be specified")
    @Size(max = MAXIMUM_PART_NUMBER_SIZE)
    @Column(name = "item_part_number")
    private String partNumber;


}
