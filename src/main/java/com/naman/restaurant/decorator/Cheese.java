package com.naman.restaurant.decorator;

import com.naman.restaurant.model.Meal;

public class Cheese extends ToppingDecorator {

    public Cheese(Meal meal) {
        super(meal);
    }

    @Override
    public String getDescription() {
        return meal.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return meal.getCost() + 1.5;
    }
}