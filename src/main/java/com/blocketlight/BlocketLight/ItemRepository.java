package com.blocketlight.BlocketLight;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemRepository {

    private List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
        items.add(new Item(1, Category.ROAD_BIKE, "Specialized S-Works Tarmac SL7", 2021, 124900, true,"https://www.bike-components.de/cache/p/xl1/7/8/Specialized-S-Works-Tarmac-SL7-Di2-Disc-Carbon-Bicycle-Model-202-carbon-color-run-silver-green-58-cm-78822-364313-1607960513.jpeg"));
        items.add(new Item(2, Category.MOUNTAIN_BIKE, "Canyon Spectral 29", 2021, 24990, true,"https://blisterreview.com/wp-content/uploads/2020/12/full_2021_spectral-cf-29-9-thumb.jpg"));
        items.add(new Item(3, Category.CYCLOCROSS, "Canyon Inflite CF SL", 2021, 34900, true,"https://media-cdn.canyon.com/dw/image/v2/BCML_PRD/on/demandware.static/-/Sites-canyon-master/default/dw7abae634/images/full/full_2021_/2021/full_2021_inflite-cf-sl-7_mc_2656_P5.png"));
        items.add(new Item(4, Category.CHILDRENS_BIKE, "Frog 40 Kids Pedal", 2021, 2990, true,"https://www.billybilslandcycles.co.uk/images/frog-40-red.png"));
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
