/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fooddeliverysystem;

/**
 *
 * @author anasa
 */
public abstract class MenuItem {

    private String name;
    private double basePrice;

    public MenuItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    protected double getBasePrice() {
        return basePrice;
    }

    public abstract double getPrice();

}
