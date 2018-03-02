package com.example.policyexpert.controllers;

import com.example.policyexpert.entities.Item;
import com.example.policyexpert.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/item")
@RestController
public class ItemController
{
    @Autowired
    ItemServices itemServices;

    @RequestMapping("create")
    public Item createItem(Item item)
    {
        itemServices.createItem(item);
        return item;
    }
}
