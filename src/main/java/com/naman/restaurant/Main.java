package com.naman.restaurant;

import com.naman.restaurant.factory.ConcreteMealFactory;
import com.naman.restaurant.factory.MealFactory;
import com.naman.restaurant.model.Meal;
import com.naman.restaurant.model.Order;

public class Main {

    public static void main(String[] args) {

        MealFactory factory = new ConcreteMealFactory();

        Meal pizza = factory.createMeal("Pizza", 12.5);
        Meal burger = factory.createMeal("Burger", 9.0);

        Order order = new Order();
        order.addMeal(pizza);
        order.addMeal(burger);

        order.printOrderSummary();
    }
}