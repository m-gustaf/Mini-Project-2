package com.blocketlight.BlocketLight;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemRepository {

    private List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
        items.add(new Item(1, "Road Bike", "Specialized Tarmac", 2021, 12990, true));
        items.add(new Item(2, "Mountain Bike", "Canyon MTB", 2021, 24990, true));
        items.add(new Item(3, "Cyclocross", "Bianchi CX", 2021, 8990, true));
    }

    public List<Item> getList() {
        return items;
    }

    public List<Item> search(String keyword) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getDescription().contains(keyword) || item.getCategory().contains(keyword)) {
                result.add(item);
            }
        }
        return result;
    }
}
