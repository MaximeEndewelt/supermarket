package com.example.policyexpert.entities;

import java.util.HashMap;
import java.util.Map;

public class ItemSelecter
{
    private static ItemSelecter INSTANCE = null;
    private Map<String, Item> items = null;

    private ItemSelecter()
    {
        items = new HashMap<>();
    }

    public static  ItemSelecter getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new ItemSelecter();
        }
        return INSTANCE;
    }

    public Map<String, Item> getItems()
    {
        return items;
    }
}
