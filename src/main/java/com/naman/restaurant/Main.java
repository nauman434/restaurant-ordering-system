package com.naman.restaurant;

import com.naman.restaurant.factory.ConcreteMealFactory;
import com.naman.restaurant.factory.MealFactory;
import com.naman.restaurant.model.Meal;
import com.naman.restaurant.model.Order;
import com.naman.restaurant.payment.*;
import com.naman.restaurant.decorator.*;
import com.naman.restaurant.observer.*;
import com.naman.restaurant.builder.MealBuilder;

public class Main {

    public static void main(String[] args) {

        MealFactory factory = new ConcreteMealFactory();
        Meal pizza = new MealBuilder("Pizza", 12.5)
                .addCheese()
                .addOlives()
                .addMushroom()
                .build();
        Meal burger = factory.createMeal("Burger", 9.0);

        Order order = new Order();
        order.addMeal(pizza);
        order.addMeal(burger);

        order.printOrderSummary();

        order.setPaymentStrategy(new CreditCardPayment("1234567812345678"));

        KitchenDisplay kitchen = new KitchenDisplay();
        CustomerNotification customer = new CustomerNotification();

        order.registerObserver(kitchen);
        order.registerObserver(customer);

        order.checkout();


    }
}