package com.pluralsight;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.time.*;

import static com.pluralsight.MenuMethods.*;

public class PaymentMethods {
    public static LocalDateTime today = LocalDateTime.now();
    public static Scanner userInput = new Scanner(System.in);
    public static final DecimalFormat df = new DecimalFormat("#.00");
    public static HashMap<Integer, Transaction> newTransactionMap = new HashMap<Integer, Transaction>();
    public static void makePayment(){
        try{
            System.out.print("Please enter the description of the payment (item name, service, etc.): ");
            String description = userInput.nextLine();
            System.out.print("Please enter the vendor who is receiving the payment (Ex: Amazon, Walmart, etc.): ");
            String vendor = userInput.nextLine();
            System.out.print("Please enter the cost of the payment (Ex: $12.34): $");
            double amount = (Double.parseDouble(df.format(userInput.nextDouble())) * -1);
            userInput.nextLine();
            userInput.reset();
            String date = Integer.toString(today.getYear()) + "-" + Integer.toString(today.getMonthValue()) + "-" + Integer.toString(today.getDayOfMonth());
            String time = Integer.toString(today.getHour()) + ":" + Integer.toString(today.getMinute()) + ":" + Integer.toString(today.getSecond());
            Transaction newTransaction = new Transaction(date, time, description, vendor, amount);
            newTransactionMap.put((newTransactionMap.size()),newTransaction);
            System.out.println("\nYour payment has been successfully added! Now returning to the main menu...");
            mainMenu();
        }
        catch(Exception inputError){
            System.out.println("Please enter a valid cost of payment. Returning to payment screen...");
            makePayment();
        }
    }
    //based off of given info, adds new (payment) transaction object to new transaction map
    public static void makeDeposit(){
        try{
            LocalDateTime today = LocalDateTime.now();
            System.out.print("Please enter the description of the deposit (service, reason, etc.): ");
            String description = userInput.nextLine();
            System.out.print("Please enter the vendor who is depositing (Ex: Amazon, Your name, etc.): ");
            String vendor = userInput.nextLine();
            System.out.print("Please enter the deposit amount (Ex: $12.34): $");
            double amount = Double.parseDouble(df.format(userInput.nextDouble()));
            userInput.nextLine();
            userInput.reset();
            String date = Integer.toString(today.getYear()) + "-" + Integer.toString(today.getMonthValue()) + "-" + Integer.toString(today.getDayOfMonth());
            String time = Integer.toString(today.getHour()) + ":" + Integer.toString(today.getMinute()) + ":" + Integer.toString(today.getSecond());
            Transaction newTransaction = new Transaction(date, time, description, vendor, amount);
            newTransactionMap.put((newTransactionMap.size()),newTransaction);
            System.out.println("\nYour deposit has been successfully added! Now returning to the main menu...");
            mainMenu();
        }
        catch(Exception inputError){
            System.out.println("Please enter a valid cost of deposit. Returning to payment screen...");
            makePayment();
        }
    }
    //based off of given info, adds new (deposit) transaction object to new transaction map
}
