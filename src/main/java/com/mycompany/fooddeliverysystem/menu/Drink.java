/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fooddeliverysystem;

/**
 *
 * @author anasa
 */
public class Drink extends MenuItem {

    private boolean isLarge;

    public Drink(String name, double basePrice, boolean isLarge) {
        super(name, basePrice);
        this.isLarge = isLarge;
    }

    @Override
    public double getPrice() {
        if (isLarge) {
            return getBasePrice() + 1;
        } else {
            return getBasePrice();
        }
    }
}
