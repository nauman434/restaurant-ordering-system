package com.naman.restaurant.factory;

import com.naman.restaurant.model.BaseMeal;
import com.naman.restaurant.model.Meal;

public class ConcreteMealFactory implements MealFactory {

    @Override
    public Meal createMeal(String type) {

        switch (type.toLowerCase()) {

            case "pizza":
                return new BaseMeal("Pizza", 10.0);

            case "burger":
                return new BaseMeal("Burger", 8.0);

            default:
                throw new IllegalArgumentException("Unknown meal type");
        }
    }
}