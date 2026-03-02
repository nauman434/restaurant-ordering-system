package com.naman.restaurant.model;
import com.naman.restaurant.payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;



public class Order {

    private List<Meal> meals;

    private PaymentStrategy paymentStrategy;

    public Order() {
        meals = new ArrayList<>();
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
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

    public void checkout() {

        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment method not selected.");
        }

        double total = calculateTotal();
        paymentStrategy.pay(total);
    }
}