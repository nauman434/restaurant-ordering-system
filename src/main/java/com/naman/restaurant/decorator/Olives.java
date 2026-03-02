package com.naman.restaurant.decorator;

import com.naman.restaurant.model.Meal;

public class Olives extends ToppingDecorator {

    public Olives(Meal meal) {
        super(meal);
    }

    @Override
    public String getDescription() {
        return meal.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return meal.getCost() + 1.0;
    }
}