package com.naman.restaurant;

import com.naman.restaurant.model.BaseMeal;
import com.naman.restaurant.model.Meal;
import com.naman.restaurant.model.Order;

public class Main {

    public static void main(String[] args) {

        Meal pizza = new BaseMeal("Pizza", 10.0);
        Meal burger = new BaseMeal("Burger", 8.0);

        Order order = new Order();
        order.addMeal(pizza);
        order.addMeal(burger);

        order.printOrderSummary();
    }
}