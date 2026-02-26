package com.naman.restaurant.factory;

import com.naman.restaurant.model.BaseMeal;
import com.naman.restaurant.model.Meal;

import java.util.HashSet;
import java.util.Set;

public class ConcreteMealFactory implements MealFactory {

    private Set<String> supportedMeals = new HashSet<>();

    public ConcreteMealFactory() {
        supportedMeals.add("pizza");
        supportedMeals.add("burger");
    }

    @Override
    public Meal createMeal(String type, double price) {

        if (!supportedMeals.contains(type.toLowerCase())) {
            throw new IllegalArgumentException("Unsupported meal type: " + type);
        }

        return new BaseMeal(type, price);
    }
}