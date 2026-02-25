package com.naman.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Meal> meals;

    public Order() {
        meals = new ArrayList<>();
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public double calculateTotal() {
        return meals.stream()
                .mapToDouble(Meal::getCost)
                .sum();
    }

    public void printOrderSummary() {
        for (Meal meal : meals) {
            System.out.println(meal.getDescription() + " - £" + meal.getCost());
        }
        System.out.println("Total: £" + calculateTotal());
    }
}