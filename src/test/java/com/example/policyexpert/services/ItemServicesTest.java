package com.example.policyexpert.services;

import static org.hamcrest.Matchers.*;
import com.example.policyexpert.entities.Item;
import com.example.policyexpert.exceptions.ConflictException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServicesTest
{
    @Autowired
    ItemServices services;

    @Test(expected = IllegalArgumentException.class)
    public void createItemNullTest()
    {
        services.createItem(null);
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
