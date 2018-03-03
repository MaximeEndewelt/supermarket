package com.example.policyexpert.controllers;

import com.example.policyexpert.entities.Customer;
import com.example.policyexpert.entities.Item;
import com.example.policyexpert.services.CartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cart")
@RestController
public class CartController
{
    @Autowired
    CartServices cartServices;

    @RequestMapping(value="add" ,method= RequestMethod.POST)
    public void addItem(Customer customer, Item item, int quantity)
    {
        cartServices.addToCart(item, customer, quantity);
    }
}
