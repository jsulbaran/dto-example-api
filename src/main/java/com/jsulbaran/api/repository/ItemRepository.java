package com.jsulbaran.api.repository;

import com.jsulbaran.api.model.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {
}
