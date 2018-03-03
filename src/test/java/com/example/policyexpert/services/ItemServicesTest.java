package com.example.policyexpert.services;

import static org.hamcrest.Matchers.*;
import com.example.policyexpert.entities.Item;
import com.example.policyexpert.exceptions.ConflictException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServicesTest
{
    ItemServices services;

    @Before
    public void setUp()
    {
        services = new ItemServices();
    }


    @Test(expected = IllegalArgumentException.class)
    public void createItemNullTest()
    {
        services.createItem(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemNullNameTest()
    {
        Item item = new Item("", 2.0, Item.ItemType.WEIGHT);
        services.createItem(item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemNegativePriceTest()
    {
        Item item = new Item("oranges", -2., Item.ItemType.WEIGHT);
        services.createItem(item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createItemNullTypeTest()
    {
        Item item = new Item("oranges", 2., null);
        services.createItem(item);
    }

    @Test(expected = ConflictException.class)
    public void createItemExistingTest()
    {
        Item item = new Item("oranges", 2.0, Item.ItemType.WEIGHT);
        services.createItem(item);

        item = new Item("oranges", 3.0, Item.ItemType.WEIGHT);

        // Trigger exception
        services.createItem(item);
    }

    @Test
    public void createItemOkTest()
    {
        Item item = new Item("oranges", 2.0, Item.ItemType.WEIGHT);
        services.createItem(item);

        Assert.assertThat(services.items.size(), is(1));

        item = new Item("butter", 3.0, Item.ItemType.UNIT);

        // Trigger exception
        services.createItem(item);
        Assert.assertThat(services.items.size(), is(2));

    }
}
