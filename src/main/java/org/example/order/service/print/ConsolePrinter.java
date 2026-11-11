package org.example.order.service.print;

import org.example.order.model.Order;
import org.example.order.service.print.interfaces.Printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(Order order, double discount, double commission, double finalAmount) {
        System.out.println("=== RECEIPT ===");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Items: " + order.getItems());
        System.out.println("Base amount: " + order.getAmount());
        System.out.println("Discount: -" + discount);
        System.out.println("Commission: +" + commission);
        System.out.println("Final amount: " + finalAmount);
        System.out.println("================");
    }
}
