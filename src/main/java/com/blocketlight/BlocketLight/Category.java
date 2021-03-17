package com.blocketlight.BlocketLight;

public enum Category {
    CHOOSE("Choose..."),
    ROAD_BIKE("Road Bike"),
    MOUNTAIN_BIKE("Mountain Bike"),
    CYCLOCROSS("Cyclocross"),
    CHILDRENS_BIKE("Childrens Bike"),
    ELECTRIC_BIKE("Electric Bike");

    private final String displayValue;

    Category(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
