package com.pluralsight;

import java.io.File;
import java.util.Scanner;

import static com.pluralsight.PaymentMethods.*;

public class MenuMethods {
    public static Scanner userInput = new Scanner(System.in);
    public static void mainMenu(){
        System.out.print("\nPlease choose an option (1, 2, 3, or 4): \n\t1) Add Deposit\n\t2) Make Payment (Debit)\n\t3) Ledger\n\t4) Exit\nUser Input: ");
        String input = userInput.nextLine();
        userInput.reset();
        switch(input){
            case ("1"):
                makeDeposit();
                break;
            case("2"):
                makePayment();
                break;
            case("3"):
                ledgerMenu();
                break;
            case("4"):
                System.out.println("Thank you, & see you again soon!");
                break;
            default:
                System.out.println("\nPlease enter a valid option (1, 2, 3, or 4).");
                mainMenu();
                break;
        }
    }
    public static void ledgerMenu(){

    }
}
