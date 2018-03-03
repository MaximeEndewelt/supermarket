package com.example.policyexpert.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart
{
    List<Map<Item, Integer>> items;

    public Cart()
    {
        this.items = new ArrayList<>();
    }

    public void addToCart(Item item, int quantity)
    {
        // To implement
    }
}
