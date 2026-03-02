package com.naman.restaurant.observer;

public class KitchenDisplay implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Kitchen notified: " + message);
    }
}