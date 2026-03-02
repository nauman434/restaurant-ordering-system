package com.naman.restaurant.decorator;

import com.naman.restaurant.model.Meal;

public abstract class ToppingDecorator extends Meal {

    protected Meal meal;

    public ToppingDecorator(Meal meal) {
        this.meal = meal;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getCost();
}