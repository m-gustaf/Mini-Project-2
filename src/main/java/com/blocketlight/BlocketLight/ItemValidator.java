package com.blocketlight.BlocketLight;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ItemValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Item.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors e) {

        // another way of doing validation - manually checking values
        Item item = (Item)object;
        if (item.getPrice()== null || item.getPrice() < 0) {
            e.rejectValue("price", "negativevalue");
        }
        if (item.getBuildYear()== null || item.getBuildYear() < 0) {
            e.rejectValue("buildYear", "negativevalue");
        }
        if (item.getCategory().getDisplayValue().equals("Choose a category")) {
            e.rejectValue("category", "category.empty");
        }
        if (item.getDescription() == null || item.getDescription().equals("")) {
            e.rejectValue("description", "description.empty");
        }
        if (item.getImageURL() == null || item.getImageURL().equals("")) {
            e.rejectValue("imageURL", "imageURL.empty");
        }
    }

}
