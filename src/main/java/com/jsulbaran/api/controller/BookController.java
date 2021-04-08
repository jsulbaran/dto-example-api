package com.jsulbaran.api.controller;

import com.jsulbaran.api.dto.BookDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class BookController {
    private final ModelMapper modelMapper;

    @PostMapping("/")
    public BookDTO.Response.InStock createInStockItem(@RequestBody @Valid BookDTO.Request.Create bookDTO) {

        return new BookDTO.Response.InStock("hola","1234566",new BigDecimal("123.54"));
    }
}
