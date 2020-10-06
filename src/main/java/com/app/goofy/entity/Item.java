package com.app.goofy.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table
public class Item {

    @Id
    private Long id;

    public Item(Long id, String itemName, Double itemPrice, String category) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.category = category;
    }

    private String itemName;
    private Double itemPrice;
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
