package com.pluralsight;

import static com.pluralsight.MenuMethods.*;
import static com.pluralsight.PaymentMethods.df;
import static com.pluralsight.PaymentMethods.newTransactionMap;
import static com.pluralsight.FileManipulation.transactionMap;
//importing the public Hashmaps that are used to store the new and old transaction objects, main menu recursive methods, and decimal formatting for prices

public class DisplayFunctionality {
    public static void showAll(){
        System.out.print("\nAll ledger entries: \ndate | time | description | vendor | amount");
        for(Transaction nt: newTransactionMap.values()){
            System.out.print("\n" + nt.getDate() + " | " + nt.getTime() + " | " + nt.getDescription() + " | " + nt.getVendor() + " | $" + df.format(nt.getAmount()));
        }
        for(Transaction t: transactionMap.values()){
            System.out.print("\n" + t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | $" + df.format(t.getAmount()));
        }
        System.out.println("\n\nReturning to the main menu...");
        mainMenu();
    }
    //will run through every single transaction object from the new Hashmap and the old Hashmap (these are in separate maps to append when writing to csv and to show new transactions first)
    public static void showPayments(){
        System.out.print("\nAll payment entries: \ndate | time | description | vendor | amount");
        for(Transaction nt: newTransactionMap.values()){
            if(nt.getAmount() < 0){
                System.out.print("\n" + nt.getDate() + " | " + nt.getTime() + " | " + nt.getDescription() + " | " + nt.getVendor() + " | $" + df.format(nt.getAmount()));
            }
        }
        for(Transaction t: transactionMap.values()){
            if(t.getAmount() < 0){
                System.out.print("\n" + t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | $" + df.format(t.getAmount()));
            }
        }
        System.out.println("\n\nReturning to the main menu...");
        mainMenu();
    }
    //will run through all the 'payment' transactions (shown by negative amount value)
    public static void showDeposits(){
        System.out.print("\nAll deposit entries: \ndate | time | description | vendor | amount");
        for(Transaction nt: newTransactionMap.values()){
            if(nt.getAmount() > 0){
                System.out.print("\n" + nt.getDate() + " | " + nt.getTime() + " | " + nt.getDescription() + " | " + nt.getVendor() + " | $" + df.format(nt.getAmount()));
            }
        }
        for(Transaction t: transactionMap.values()){
            if(t.getAmount() > 0){
                System.out.print("\n" + t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | $" + df.format(t.getAmount()));
            }
        }
        System.out.println("\n\nReturning to the main menu...");
        mainMenu();
    }
    //will run through all the 'deposit' transactions (shown by positive amount value)
}
