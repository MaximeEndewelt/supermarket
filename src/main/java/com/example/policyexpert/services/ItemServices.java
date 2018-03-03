package com.example.policyexpert.services;

import com.example.policyexpert.entities.Item;
import com.example.policyexpert.exceptions.ConflictException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemServices
{
    /** Map associating a item name to an item entity */
    Map<String, Item> items = new HashMap<>();

    public Item createItem(Item item)
    {
        // Validate the given iten
        this.validateItem(item);

        // And put it in the map
        items.put(item.getName(), item);
        return  item;
    }


    private void validateItem(Item item)
    {
        //
        // General validation
        //
        if(item == null || item.getName() == null ||
           item.getName().isEmpty())
        {
            throw new IllegalArgumentException("Item must have a name");
        }

        if(item.getPrice() <= 0.)
        {
            throw new IllegalArgumentException("Item must have a positive decimal value");
        }

        if( item.getType() == null ||
           !item.getType().equals(Item.ItemType.WEIGHT) &&
           !item.getType().equals(Item.ItemType.UNIT))
        {
            throw new IllegalArgumentException("Item must have a type \"unit\" or \"weight\"");
        }

        //
        // Check if the item doesn't already exist
        //
        if(items.get(item.getName()) != null)
        {
            throw new ConflictException("The item already exist");
        }
    }
}
