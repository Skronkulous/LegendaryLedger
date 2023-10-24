package com.pluralsight;

import java.io.File;
import java.util.Scanner;

import static com.pluralsight.DisplayFunctionality.*;
import static com.pluralsight.FileManipulation.csvWriter;
import static com.pluralsight.PaymentMethods.*;
import static com.pluralsight.SearchFunctionality.*;

public class MenuMethods {
    public static Scanner userInput = new Scanner(System.in);
    //Main menu to navigate through entire program
    public static void mainMenu(){
        System.out.print("\nMain Menu:\nPlease choose an option (1, 2, 3, or 4): \n\t1) Add Deposit\n\t2) Make Payment (Debit)\n\t3) Ledger\n\t4) Exit\nUser Input: ");
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
                csvWriter();
                break;
            default:
                System.out.println("\nPlease enter a valid option (1, 2, 3, or 4).");
                mainMenu();
                break;
        }
    }
    //Ledger menu for user to choose how to manipulate the ledger list
    public static void ledgerMenu(){
        System.out.print("\nLedger Menu:\nPlease choose an option (1, 2, 3, 4, or 5):\n\t1) Display all entries\n\t2) Display Deposits\n\t3) Display Payments\n\t4) Run report search\n\t5) Return to main menu\nUser Input: ");
        String input = userInput.nextLine();
        switch(input){
            case ("1"):
                showAll();
                break;
            case("2"):
                showDeposits();
                break;
            case("3"):
                showPayments();
                break;
            case("4"):
                searchMenu();
                break;
            case("5"):
                System.out.println("Returning to main menu...");
                mainMenu();
                break;
            default:
                System.out.println("\nPlease enter a valid option (1, 2, 3, or 4).");
                ledgerMenu();
                break;
        }
    }
    //Search menu for user to narrow down the list of transactions
    public static void searchMenu(){
        System.out.print("\nSearch Menu:\nPlease choose an option (1 - 7):\n\t1) Month to date\n\t2) Previous month\n\t3) Year to date\n\t4) Previous year\n\t5) Vendor search\n\t6) Custom search\n\t7)Return to ledger menu\nUser Input: ");
        String input = userInput.nextLine();
        switch(input){
            case ("1"):
                monthToDateSearch();
                break;
            case("2"):
                previousMonthSearch();
                break;
            case("3"):
                yearToDateSearch();
                break;
            case("4"):
                previousYearSearch();
                break;
            case("5"):
                vendorSearch();
                break;
            case("6"):
                customSearch();
                break;
            case("7"):
                System.out.println("Returning to main menu...");
                mainMenu();
                break;
            default:
                System.out.println("\nPlease enter a valid option (1, 2, 3, or 4).");
                searchMenu();
                break;
        }
    }
}
