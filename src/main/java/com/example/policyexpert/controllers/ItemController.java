package com.example.policyexpert.controllers;

import com.example.policyexpert.entities.Item;
import com.example.policyexpert.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/item")
@RestController
public class ItemController
{
    private ItemServices itemServices;

    public ItemController(ItemServices services)
    {
        this.itemServices = services;
    }

    @RequestMapping(value="create" ,method= RequestMethod.POST)
    public Item createItem(Item item)
    {
        itemServices.createItem(item);
        return item;
    }

    @RequestMapping(method=RequestMethod.GET)
    public List<Item> listItems()
    {
        return null;
    }
}
