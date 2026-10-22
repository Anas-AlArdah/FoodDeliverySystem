/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.fooddeliverysystem;

/**
 *
 * @author anasa
 */
public class FoodDeliverySystem {

    public static void main(String[] args) {
        
        // TEST 1: ORDER WITH CARD PAYMENT
  

        System.out.println("===== ORDER 1: CARD PAYMENT =====");

        // Create menu items
        Meal burger = new Meal("Burger", 8.0, 1);
        Drink juice = new Drink("Juice", 3.0, true);

        // Create order with Express Delivery
        Order order1 = new Order("Anas", new ExpressDelivery());

        // Add items
        order1.addItem(burger, 2);
        order1.addItem(juice);

        // Print items
        System.out.println("Customer: Anas");
        System.out.println("Meal: " + burger.getName() + " x 2");
        System.out.println("Drink: " + juice.getName() + " x 1");

        // Print calculations
        System.out.println("Subtotal: " + order1.getSubtotal());
        System.out.println("Total: " + order1.getTotal());
        System.out.println("Status: " + order1.getStatus());

        // Pay using Card
        double cardAmount = order1.pay(new CardPayment());

        System.out.println("Paid Amount: " + cardAmount);
        System.out.println("Status After Payment: " + order1.getStatus());

        // Deliver order
        order1.deliver();

        System.out.println("Status After Delivery: " + order1.getStatus());


        
        // TEST 2: ORDER WITH CASH PAYMENT
        

        System.out.println();
        System.out.println("===== ORDER 2: CASH PAYMENT =====");

        // Create order with Standard Delivery
        Order order2 = new Order("Ahmad", new StandardDelivery());

        // Add one Burger
        order2.addItem(burger);

        System.out.println("Customer: Ahmad");
        System.out.println("Meal: " + burger.getName() + " x 1");

        System.out.println("Subtotal: " + order2.getSubtotal());
        System.out.println("Total: " + order2.getTotal());

        // Pay using Cash
        double cashAmount = order2.pay(new CashPayment());

        System.out.println("Paid Amount: " + cashAmount);
        System.out.println("Status: " + order2.getStatus());


        
        // TEST 3: CANCEL ORDER
        

        System.out.println();
        System.out.println("===== ORDER 3: CANCELLATION =====");

        Order order3 = new Order("Omar", new ExpressDelivery());

        System.out.println("Before Cancel: " + order3.getStatus());

        order3.cancel();

        System.out.println("After Cancel: " + order3.getStatus());

        // Try to pay a cancelled order
        try {
            order3.pay(new CardPayment());
        } catch (IllegalStateException e) {
            System.out.println("Payment Rejected: " + e.getMessage());
        }
    }
}
