package com.blocketlight.BlocketLight;

public class Item {
    private int id;
    private Category category;
    private String description;
    private int buildYear;
    private double price;
    private boolean isAvailable;
    private String imageURL;

    public Item(int id, Category category, String description, int buildYear, double price, boolean isAvailable, String imageURL) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.buildYear = buildYear;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageURL = imageURL;

    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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




