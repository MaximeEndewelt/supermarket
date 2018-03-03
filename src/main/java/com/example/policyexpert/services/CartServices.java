package com.example.policyexpert.services;

import com.example.policyexpert.entities.Cart;
import com.example.policyexpert.entities.Customer;
import com.example.policyexpert.entities.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServices
{
    Map<Customer, Cart> cutomerItems = new HashMap<>();

    public void addToCart(Item item, Customer customer, int quantity)
    {
        // To implement
    }
}
