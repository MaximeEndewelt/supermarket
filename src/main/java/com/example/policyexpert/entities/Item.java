package com.example.policyexpert.entities;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Item
{
    private final String name;
    private double price;
    private ItemType type;

    public Item(String name, double price, ItemType type)
    {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName()
    {
        return name;
    }


    public enum ItemType
    {
        UNIT("unit"),
        WEIGHT("weight");

        private String type;

        ItemType(String type)
        {
            this.type = type;
        }

        @Override
        public String toString()
        {
            return type;
        }

        @JsonCreator
        public static ItemType create (String value) {
            if(value == null)
            {
                throw new IllegalArgumentException();
            }
            for(ItemType type : values())
            {
                if(value.equals(type.getType()))
                {
                    return type;
                }
            }

            throw new IllegalArgumentException();
        }

        private String getType()
        {
            return type;
        }


    }

}
