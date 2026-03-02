package com.naman.restaurant.builder;

import com.naman.restaurant.decorator.*;
import com.naman.restaurant.factory.ConcreteMealFactory;
import com.naman.restaurant.factory.MealFactory;
import com.naman.restaurant.model.Meal;

public class MealBuilder {

    private Meal meal;
    private MealFactory factory = new ConcreteMealFactory();

    public MealBuilder(String type, double price) {
        this.meal = factory.createMeal(type, price);
    }

    public MealBuilder addCheese() {
        meal = new Cheese(meal);
        return this;
    }

    public MealBuilder addOlives() {
        meal = new Olives(meal);
        return this;
    }

    public MealBuilder addMushroom() {
        meal = new Mushroom(meal);
        return this;
    }

    public Meal build() {
        return meal;
    }
}