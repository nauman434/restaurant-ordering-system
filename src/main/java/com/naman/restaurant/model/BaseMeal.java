package com.naman.restaurant.model;

public class BaseMeal extends Meal {

    private String name;
    private double price;

    public BaseMeal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public double getCost() {
        return price;
    }
}