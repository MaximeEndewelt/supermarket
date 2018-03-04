package com.example.policyexpert.entities;

public class Discount
{
    private final String itemName;
    private final int quantity;
    private final double price;

    public Discount(String itemName, int quantity, double price)
    {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemName()
    {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
