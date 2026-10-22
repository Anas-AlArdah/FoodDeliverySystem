/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fooddeliverysystem;

/**
 *
 * @author anasa
 */
public class OrderLine {

    private MenuItem item;
    private int quantity;

    public OrderLine(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getLineTotal() {
        return item.getPrice() * quantity;
    }
}
