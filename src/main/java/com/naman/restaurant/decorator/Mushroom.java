package com.naman.restaurant.decorator;

import com.naman.restaurant.model.Meal;

public class Mushroom extends ToppingDecorator {

    public Mushroom(Meal meal) {
        super(meal);
    }

    @Override
    public String getDescription() {
        return meal.getDescription() + ", Mushroom";
    }

    @Override
    public double getCost() {
        return meal.getCost() + 1.2;
    }
}