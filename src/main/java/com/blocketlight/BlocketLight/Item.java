package com.blocketlight.BlocketLight;

public class Item {
    private int id;
    private String category;
    private String description;
    private int buildYear;
    private double price;
    private boolean isAvailable;

    public Item(int id, String category, String description, int buildYear, double price, boolean isAvailable) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.buildYear = buildYear;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(int buildYear) {
        this.buildYear = buildYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }
}




