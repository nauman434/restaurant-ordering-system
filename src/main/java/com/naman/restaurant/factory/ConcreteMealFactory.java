package com.naman.restaurant.factory;

import com.naman.restaurant.model.BaseMeal;
import com.naman.restaurant.model.Meal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ConcreteMealFactory implements MealFactory {

    private Map<String, Supplier<Meal>> mealRegistry = new HashMap<>();

    public ConcreteMealFactory() {

        mealRegistry.put("pizza", () -> new BaseMeal("Pizza", 10.0));
        mealRegistry.put("burger", () -> new BaseMeal("Burger", 8.0));
    }

    @Override
    public Meal createMeal(String type) {

        Supplier<Meal> mealSupplier = mealRegistry.get(type.toLowerCase());

        if (mealSupplier != null) {
            return mealSupplier.get();
        }

        throw new IllegalArgumentException("Unknown meal type: " + type);
    }
}