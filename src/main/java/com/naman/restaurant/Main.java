package com.naman.restaurant;

import com.naman.restaurant.factory.ConcreteMealFactory;
import com.naman.restaurant.factory.MealFactory;
import com.naman.restaurant.model.Meal;
import com.naman.restaurant.model.Order;

public class Main {

    public static void main(String[] args) {

        MealFactory factory = new ConcreteMealFactory();

        Meal pizza = factory.createMeal("pizza");
        Meal burger = factory.createMeal("burger");

        Order order = new Order();
        order.addMeal(pizza);
        order.addMeal(burger);

        order.printOrderSummary();
    }
}