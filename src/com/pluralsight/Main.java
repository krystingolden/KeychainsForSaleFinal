package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /*
    https://programmingbydoing.com/

    Keychains for sale final - Assignment #110
     */
    public static void main(String[] args) {
        // write your code here

        System.out.println("Ye Olde Keychain Shoppe");
        System.out.println();

        //Start order
        runMenu();

        //End order
        goodbye();
    }

    public static void runMenu() {

        Scanner kb = new Scanner(System.in);
        int choice = 0;
        Keychains keychain = new Keychains();

        //Print the menu and prompt the user for their choice
        while (choice != 4) {
            System.out.println("1. Add Keychains to Order ");
            System.out.println("2. Remove Keychains from Order  ");
            System.out.println("3. View Current Order");
            System.out.println("4. Checkout     ");


            do {
                System.out.print("\nPlease enter your choice: ");

                try {
                    choice = kb.nextInt();
                    if (choice == 1 || choice == 3) {
                        break;
                    }
                    else if (choice == 2){
                        if (keychain.getNumKeychains() > 0){
                            break;
                        }
                        else {
                            System.out.println("There are no keychains. You can't remove any");
                        }
                    }
                    else if (choice == 4){
                        if (keychain.getNumKeychains() > 0){
                            break;
                        }
                        else {
                            System.out.println("There are no keychains. There is nothing to checkout");
                        }
                    }
                    else {
                        System.out.println("Must be a number from 1 to 4");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Must be a number from 1 to 4");
                    kb.next();
                }
            }
            while (true);


            System.out.println();

            //Menu option #1 - ADD KEYCHAINS
            if (choice == 1) {
                System.out.println("You have " + keychain.getNumKeychains() + ".");
                do {
                    System.out.print("How many would you like to add?");

                    try {
                        int numAdd = kb.nextInt();
                        if (numAdd > 0) {
                            keychain.addKeychains(numAdd);
                            break;
                        } else {
                            System.out.println("Must be a number greater than 0");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Must be a number");
                        kb.next();
                    }
                }
                while (true);

                //Menu option #2 - REMOVE KEYCHAINS
            } else if (choice == 2) {
                System.out.println("You have " + keychain.getNumKeychains() + ".");
                do {
                    System.out.print("How many would you like to remove?");

                    try {
                        int numRemove = kb.nextInt();
                        if (numRemove > 0 && numRemove <= keychain.getNumKeychains()) {
                            keychain.removeKeychains(numRemove);
                            break;
                        } else if (numRemove <= 0){
                            System.out.println("Must be a number greater than 0");
                        }
                        else {
                            System.out.println("That's too many. Number must be " + keychain.getNumKeychains() + " or less");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Must be a number");
                        kb.next();
                    }
                }
                while (true);

                //Menu option #3 - VIEW ORDER
            } else if (choice == 3) {
                keychain.viewOrder();

                //Menu option #4 - CHECKOUT
            } else {
                keychain.checkout();
            }

        }
    }

    public static void goodbye() {
        System.out.println("\nGoodbye!");
    }

}

