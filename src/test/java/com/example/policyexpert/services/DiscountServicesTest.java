package com.example.policyexpert.services;

import static org.hamcrest.Matchers.*;
import com.example.policyexpert.entities.Discount;
import com.example.policyexpert.entities.Item;
import com.example.policyexpert.exceptions.ConflictException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiscountServicesTest
{
    DiscountServices services;

    @Before
    public void setUp()
    {
        services = new DiscountServices();
    }

    @Test(expected = IllegalArgumentException.class)
    public void createDiscountNullTest()
    {
        services.createDiscount(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createDiscountNullItemNameTest()
    {
        Discount discount = new Discount(null, 2, 1.);
        services.createDiscount(discount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createDiscountNoSuchItemTest()
    {
        Discount discount = new Discount("oranges", 2, 1.);
        services.createDiscount(discount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createDiscountNegativeQuantityTest()
    {
        Discount discount = new Discount("oranges", -2, 1.);
        services.createDiscount(discount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createDiscountOnWeightItemTest()
    {
        Item item = new Item("oranges", 2., Item.ItemType.WEIGHT);
        Discount discount = new Discount("oranges", 2, 1.);
        services.createDiscount(discount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createDiscountNegativePriceDiscountTest()
    {
        Item item = new Item("cans", 2., Item.ItemType.UNIT);
        Discount discount = new Discount("cans", 2, -1.);
        services.createDiscount(discount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createDiscountDiscountHigherThanActualPriceTest()
    {
        Item item = new Item("cans", 2., Item.ItemType.UNIT);
        Discount discount = new Discount("cans", 2, 5.0);
        services.createDiscount(discount);
    }

    @Test(expected = ConflictException.class)
    public void createDiscountDuplicateDiscountTest()
    {
        Item item = new Item("cans", 2., Item.ItemType.UNIT);

        Discount discount = new Discount("cans", 2, 1.);
        services.createDiscount(discount);

        Discount discount1 = new Discount("cans", 2, 6.);

        //Trigger exception
        services.createDiscount(discount1);

    }

    @Test
    public void createDiscountOkTest()
    {
        Item item = new Item("cans", 2., Item.ItemType.UNIT);
        Item item1 = new Item("coke", 4., Item.ItemType.UNIT);

        Discount discount = new Discount("cans", 2, 1.);
        services.createDiscount(discount);
        Assert.assertThat(services.discounts.size(), is(1));

        Discount discount1 = new Discount("coke", 2, 6.);
        services.createDiscount(discount1);
        Assert.assertThat(services.discounts.size(), is(2));

    }
}
