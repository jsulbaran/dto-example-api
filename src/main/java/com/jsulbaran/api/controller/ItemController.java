package com.jsulbaran.api.controller;

import com.jsulbaran.api.dto.ItemDTORequest;
import com.jsulbaran.api.dto.ItemDTOResponse;
import com.jsulbaran.api.exception.ItemNotFoundException;
import com.jsulbaran.api.model.Item;
import com.jsulbaran.api.repository.ItemRepository;

import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ItemDTOResponse getItem(@Valid @PathVariable long id) {
        final Optional<Item> foundItem = itemRepository.findById(id);
        return foundItem.map(item -> modelMapper.map(item, ItemDTOResponse.class))
                .orElseThrow(ItemNotFoundException::new);
    }

    @GetMapping(value = {"/", ""})
    public List<ItemDTOResponse> listItems() {
        final Iterable<Item> items = itemRepository.findAll();
        return StreamSupport.stream(items.spliterator(), false)
                .map(s -> modelMapper.map(s, ItemDTOResponse.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = {"/", ""})
    public ItemDTOResponse createItem(@RequestBody @Valid ItemDTORequest itemDTORequest) {
        Item item = modelMapper.map(itemDTORequest, Item.class);
        item = itemRepository.save(item);
        return modelMapper.map(item, ItemDTOResponse.class);
    }

}
