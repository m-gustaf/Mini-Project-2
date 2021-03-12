package com.blocketlight.BlocketLight;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemRepository {

    private List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
        items.add(new Item(1, Category.ROAD_BIKE, "Specialized Tarmac", 2021, 12990, true));
        items.add(new Item(2, Category.MOUNTAIN_BIKE, "Canyon MTB", 2021, 24990, true));
        items.add(new Item(3, Category.CYCLOCROSS, "Bianchi CX", 2021, 8990, true));
        items.add(new Item(4, Category.CHILDRENS_BIKE, "Monark Kids", 2021, 990, true));
        items.add(new Item(5, Category.ELECTRIC_BIKE, "Crescent Electric", 2021, 19990, true));
    }

    public List<Item> getList() {
        return items;
    }

    public Item getItem(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> search(String keyword) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getDescription().contains(keyword)) {
                result.add(item);
            }
        }
        return result;
    }
}
