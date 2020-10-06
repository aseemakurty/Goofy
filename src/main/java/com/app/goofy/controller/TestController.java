package com.app.goofy.controller;

import com.app.goofy.entity.Item;
import com.app.goofy.repository.ItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@RestController
public class TestController {

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Flux<Item> getItemById(@RequestHeader HttpHeaders headers){
            return itemRepository.findAll();
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Mono<Item> createItem(@RequestBody Item itemInfo, @RequestHeader HttpHeaders headers){
        return itemRepository.save(itemInfo);
    }

//    @RequestMapping(value = "/put", method = RequestMethod.PUT)
//    public Mono<Item> updateById(@RequestBody Item itemInfo, @RequestHeader HttpHeaders headers){
//        return itemRepository.updateById(itemInfo.getId(),itemInfo.getItemName());
//    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id, @RequestHeader HttpHeaders headers){
         itemRepository.deleteById(id);
    }


}
