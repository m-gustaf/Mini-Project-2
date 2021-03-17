package com.blocketlight.BlocketLight;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemRepository {

    private List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
        items.add(new Item(1, Category.ROAD_BIKE, "Specialized Tarmac", 2021, 12990, true,"https://03.cdn37.se/p6/images/2.1914165/specialized-tarmac-sl6-2021.jpeg"));
        items.add(new Item(2, Category.MOUNTAIN_BIKE, "Canyon MTB", 2021, 24990, true,"https://www.canyon.com/dw/image/v2/BCML_PRD/on/demandware.static/-/Library-Sites-canyon-shared/default/dw6fe9f70f/images/plp/Mountain/Spectral/27-5er-canyon-spectral-12.jpg?sw=1280&sh=650&sm=cut"));
        items.add(new Item(3, Category.CYCLOCROSS, "Bianchi CX", 2021, 8990, true,"https://www.bianchi.com/wp-content/uploads/2020/09/YQB51IZD.jpg"));
        items.add(new Item(4, Category.CHILDRENS_BIKE, "Monark Kids", 2021, 990, true,"https://www.cykellagret.se/productfiles/images/d/d7975e67-00b5-4b70-be2e-aecf091d4151_large.jpg?width=345"));
        items.add(new Item(5, Category.ELECTRIC_BIKE, "Crescent Electric", 2021, 19990, true,"https://www.elcykelpunkten.se/wp-content/uploads/2020/02/YEC937__55-1-1080x722.jpg"));
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
        item.setId(items.size()+1);
        item.setIsAvailable(true);
        items.add(item);
    }

    public void deleteItem (int id) {
        items.remove(getItem(id));
    }

    public List<Item> search(String keyword) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getDescription().contains(keyword)) {
                result.add(item);
            }
        }

        if(result.size() > 0){
          return result;
        }
        else{
            return null;
        }
    }
}
