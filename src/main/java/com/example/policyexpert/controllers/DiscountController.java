package com.example.policyexpert.controllers;

import com.example.policyexpert.entities.Discount;
import com.example.policyexpert.entities.Item;
import com.example.policyexpert.services.DiscountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/discount")
@RestController
public class DiscountController
{
    private DiscountServices discountServices;

    public DiscountController(DiscountServices services)
    {
        this.discountServices = services;
    }

    @RequestMapping(value="create" ,method= RequestMethod.POST)
    public Discount createDiscount(Discount discount)
    {
        discountServices.createDiscount(discount);
        return discount;
    }
}
