package com.naman.restaurant.factory;

import com.naman.restaurant.model.Meal;

public interface MealFactory {

    Meal createMeal(String type);

}