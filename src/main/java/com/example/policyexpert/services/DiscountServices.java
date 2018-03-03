package com.example.policyexpert.services;

import com.example.policyexpert.entities.Discount;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DiscountServices
{
    Map<String, Discount> discounts;

    public Discount createDiscount(Discount discount)
    {
        discounts.put(discount.getItemName(), discount);
        return discount;
    }

}
