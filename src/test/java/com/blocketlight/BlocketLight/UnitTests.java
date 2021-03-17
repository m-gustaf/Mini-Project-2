package com.blocketlight.BlocketLight;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UnitTests {

    @Test
    public void searchTest(){
        ItemRepository items = new ItemRepository();
        List<Item> testSearch = items.search("Magnus");
        Assert.assertEquals(null,testSearch);

        testSearch = items.search("Crescent");
        Assert.assertEquals(1,testSearch.size());
    }

    @Test
    public void addTest(){
        ItemRepository items = new ItemRepository();
        items.addItem(new Item(Category.MOUNTAIN_BIKE,"Nice bike!",2020,19900,""));
        Assert.assertEquals(6,items.getList().size());
    }
}
