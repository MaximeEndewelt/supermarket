package com.example.policyexpert.services;

import com.example.policyexpert.entities.Discount;
import com.example.policyexpert.entities.Item;
import com.example.policyexpert.entities.ItemSelecter;
import com.example.policyexpert.exceptions.ConflictException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DiscountServices
{
    Map<String, Discount> discounts = new HashMap<>();
    ItemSelecter itemSelecter;

    public DiscountServices()
    {
        // Access the Item selecter singleton
        itemSelecter = ItemSelecter.getInstance();
    }

    public Discount createDiscount(Discount discount)
    {
        this.validateDiscount(discount);
        discounts.put(discount.getItemName(), discount);
        return discount;
    }

    private void validateDiscount(Discount discount)
    {
        //
        // General validation
        //
        if(discount == null || discount.getItemName() == null ||
                discount.getItemName().isEmpty())
        {
            throw new IllegalArgumentException("Discount must refer to an item");
        }

        if(discount.getQuantity() <= 0)
        {
            throw new IllegalArgumentException("Discount quantity must have a positive  value");
        }

        if(discount.getPrice() <= 0.)
        {
            throw new IllegalArgumentException("Discount price must have a positive decimal value");
        }

        //
        // Check that the discount refers to an actual item
        //
        String itemName = discount.getItemName();
        Item item = itemSelecter.getItems().get(itemName);
        if(item == null)
        {
            throw new IllegalArgumentException("Discount must refer to an existing item");
        }

        //
        // Check that the discount refers to a 'unit' type item
        //
        if(!item.getType().equals(Item.ItemType.UNIT))
        {
            throw new IllegalArgumentException("Discount must refer to a 'unit' type item");
        }

        //
        // Check if the item doesn't already exist
        //
        if(discounts.get(discount.getItemName()) != null)
        {
            throw new ConflictException("The discount already exist");
        }

        //
        // Check that the discount is actually a discount
        // regarding the initial price of the item
        //
        double initialPrice = item.getPrice();

        int discountQuantity = discount.getQuantity();
        double discountPrice = discount.getPrice();

        if(discountQuantity*initialPrice <= discountPrice )
        {
            throw new IllegalArgumentException("Discount is not a discount (The discount price is higher than the initial price)");
        }
    }

}
