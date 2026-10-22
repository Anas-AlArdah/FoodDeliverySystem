/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fooddeliverysystem;

import java.util.ArrayList;

/**
 *
 * @author anasa
 */
public class Order {

    private static int counter = 1001;
    private int orderNumber;
    private String customerName;
    private DeliveryOption deliveryOption;
    private OrderStatus status;
    private ArrayList<OrderLine> orderLines;

    public Order(String customerName, DeliveryOption deliveryOption) {
        this.customerName = customerName;
        this.deliveryOption = deliveryOption;

        this.orderNumber = counter++;
        this.status = OrderStatus.NEW;
        this.orderLines = new ArrayList<>();
    }

    public void addItem(MenuItem item, int quantity) {
        if (status == OrderStatus.NEW && quantity >= 1) {
            OrderLine line = new OrderLine(item, quantity);
            orderLines.add(line);
        }

    }

    public void addItem(MenuItem item) {
        addItem(item, 1);
    }

    public double getSubtotal() {
        double finalPrice = 0;
        for (int i = 0; i < orderLines.size(); ++i) {
            finalPrice += orderLines.get(i).getLineTotal();
        }
        return finalPrice;
    }

    public double getTotal() {
        return getSubtotal() + deliveryOption.getFee();
    }

    public double pay(Payment payment) {

        if (status != OrderStatus.NEW) {
            throw new IllegalStateException("Cannot pay this order");
        }

        if (orderLines.isEmpty()) {
            throw new IllegalStateException("Order is empty");
        }

        double paidAmount = payment.calculatePayment(getTotal());

        this.status = OrderStatus.PAID;

        return paidAmount;
    }

    public void deliver() {
        if (this.status == OrderStatus.PAID) {
            this.status = OrderStatus.DELIVERED;
        }
    }

    public void cancel() {
        if (this.status == OrderStatus.NEW) {
            this.status = OrderStatus.CANCELLED;
        }
    }

    public OrderStatus getStatus() {
        return status;
    }

}
