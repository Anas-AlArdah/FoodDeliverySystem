/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fooddeliverysystem;

/**
 *
 * @author anasa
 */
public class Meal extends MenuItem {

    private int numToppings;

    public Meal(String name, double basePrice, int numToppings) {
        super(name, basePrice);
        this.numToppings = numToppings;
    }

    @Override
    public double getPrice() {
        return getBasePrice() + 1.5 * numToppings;
    }

}
