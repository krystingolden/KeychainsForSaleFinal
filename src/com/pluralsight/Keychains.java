package com.pluralsight;

import java.util.Scanner;

public class Keychains {
    private int numKeychains = 0;
    Scanner kb = new Scanner(System.in);


    public void addKeychains(int numAdd) {
        this.numKeychains += numAdd;
        getStatus();
    }

    public void removeKeychains(int numRemove) {
        this.numKeychains -= numRemove;
        getStatus();
    }

    public void viewOrder() {
        calculateTotal();
        System.out.println("Total cost is: $" + calculateTotal());
        System.out.println();
    }

    public void checkout() {
        System.out.println("What is your name?");
        String name = kb.next();
        System.out.println("Total cost is: $" + calculateTotal());
        System.out.println("Thanks for your order " + name + "!");
    }

    public double calculateTotal () {
        double pricePerKeychain = 10.00;
        double orderShipping = 5.00;
        double perItemShipping = 1.00;
        double salesTax = 8.25;
        double subTotal;
        double shippingCost;
        double totalCost;

        //Calculate cost for the keychains only
        System.out.println("You have " + getNumKeychains() + " keychains in your order.");
        System.out.println("Keychains cost $" + pricePerKeychain + " each.");
        System.out.println("Tax is $" + salesTax);
        subTotal = (getNumKeychains()*pricePerKeychain) * (1+(salesTax / 100));

        //Calculate cost for shipping only
        System.out.println("Shipping is $" + orderShipping + " + $" + perItemShipping + " per keychain.");
        shippingCost = ((getNumKeychains()-1)*perItemShipping) + orderShipping;

        //Calculate the total
        totalCost = subTotal + shippingCost;

        return totalCost;
    }


    public int getNumKeychains() {
        return this.numKeychains;
    }

    public void getStatus() {
        System.out.println("You have " + getNumKeychains() + " keychains in your order.");
        System.out.println();
    }
}
