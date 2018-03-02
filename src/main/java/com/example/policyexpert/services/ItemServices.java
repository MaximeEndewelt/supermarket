package com.example.policyexpert.services;

import com.example.policyexpert.entities.Item;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ItemServices
{
    Map<String, Item> items;

    public Item createItem(Item item)
    {
        items.put(item.getName(), item);
        return  item;
    }
}
