package com.blocketlight.BlocketLight;

import javax.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Category category;
    private String description;
    @Column (name="BUILD_YEAR")
    private Integer buildYear;
    private Integer price;
    @Column (name="IS_AVAILABLE")
    private boolean isAvailable;
    @Column (name="IMAGE_URL")
    private String imageURL;

    public Item(){

    }

    public Item(Integer id, Category category, String description, Integer buildYear, Integer price, boolean isAvailable, String imageURL) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.buildYear = buildYear;
        this.price = price;
        this.isAvailable = isAvailable;
        this.imageURL = imageURL;
    }

    public Item(Category category, String description, Integer buildYear, Integer price, String imageURL) {
        this.category = category;
        this.description = description;
        this.buildYear = buildYear;
        this.price = price;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(Integer buildYear) {
        this.buildYear = buildYear;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean available) {
        isAvailable = available;
    }
}




