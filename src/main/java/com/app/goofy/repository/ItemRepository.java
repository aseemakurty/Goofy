package com.app.goofy.repository;

import com.app.goofy.entity.Item;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemRepository extends ReactiveCrudRepository<Item, Long> {

//    @Query("select * from items where id = $1")
//    Mono<Item> findByItemId(Long itemId);
    Mono<Item> findById(Long itemId);
    @Query("select * from items where category = $1")
    Flux<Item> findByCategory(String category);

    @Override
     Mono<Item> save(Item item);

    // Mono<Item> updateById(Long id, String itemName);
}
