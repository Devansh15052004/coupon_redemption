package com.example.sem5_project;

public class ItemModule {

    String category;
    String name;
    String discount;
    String description;
    String coupontype;

    public ItemModule(String category, String name, String discount, String description, String coupontype) {
        this.category = category;
        this.name = name;
        this.discount = discount;
        this.description = description;
        this.coupontype = coupontype;
    }
}
