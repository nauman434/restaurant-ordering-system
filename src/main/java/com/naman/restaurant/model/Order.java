package com.naman.restaurant.model;
import com.naman.restaurant.payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;
import com.naman.restaurant.observer.Observer;
import com.naman.restaurant.observer.Subject;
import java.util.ArrayList;
import java.util.List;


public class Order implements Subject {

    private List<Meal> meals;

    private PaymentStrategy paymentStrategy;

    private List<Observer> observers = new ArrayList<>();

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

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void checkout() {

        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment method not selected.");
        }

        double total = calculateTotal();
        paymentStrategy.pay(total);

        notifyObservers("Order has been paid. Preparing now.");
    }
}