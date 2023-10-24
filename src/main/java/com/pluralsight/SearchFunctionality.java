package com.pluralsight;

import java.time.Month;

import static com.pluralsight.FileManipulation.transactionMap;
import static com.pluralsight.MenuMethods.*;
import static com.pluralsight.MenuMethods.userInput;
import static com.pluralsight.PaymentMethods.*;

public class SearchFunctionality {
    //Searches ledgers from the 1st of the month to current date
    public static void monthToDateSearch(){
        System.out.println("All ledger entries from " + today.getMonthValue() + "/1 - " + today.getMonthValue() + "/" + today.getDayOfMonth() + ": \ndate | time | description | vendor | amount");
        for(Transaction nt: newTransactionMap.values()) {
            String[] dateSplit = nt.getDate().split("-");
            if((Integer.parseInt(dateSplit[1]) == today.getMonthValue()) && (Integer.parseInt(dateSplit[2]) <= today.getDayOfMonth())){
                System.out.print("\n" + nt.getDate() + " | " + nt.getTime() + " | " + nt.getDescription() + " | " + nt.getVendor() + " | $" + df.format(nt.getAmount()));
            }
        }
        for(Transaction t: transactionMap.values()){
            String[] dateSplit = t.getDate().split("-");
            if((Integer.parseInt(dateSplit[1]) == today.getMonthValue()) && (Integer.parseInt(dateSplit[2]) <= today.getDayOfMonth())){
                System.out.print("\n" + t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | $" + df.format(t.getAmount()));
            }
        }
        System.out.println("\nReturning to main menu...");
        mainMenu();
    }
    //Searches ledgers based off of only previous month transactions
    public static void previousMonthSearch(){
        int prevMonth = 0;
        if(today.getMonthValue() == 1){
            prevMonth = 12;
        }
        else{
            prevMonth = today.getMonthValue()-1;
        }
        System.out.println("All ledger entries from " + Month.of(prevMonth).name().toLowerCase() + ": \ndate | time | description | vendor | amount");
        for(Transaction nt: newTransactionMap.values()) {
            String[] dateSplit = nt.getDate().split("-");
            if(Integer.parseInt(dateSplit[1]) == prevMonth){
                System.out.print("\n" + nt.getDate() + " | " + nt.getTime() + " | " + nt.getDescription() + " | " + nt.getVendor() + " | $" + df.format(nt.getAmount()));
            }
        }
        for(Transaction t: transactionMap.values()){
            String[] dateSplit = t.getDate().split("-");
            if(Integer.parseInt(dateSplit[1]) == prevMonth){
                System.out.print("\n" + t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | $" + df.format(t.getAmount()));
            }
        }
        System.out.println("\nReturning to main menu...");
        mainMenu();
    }
    //Searches ledger based off of 1st of year to current date
    public static void yearToDateSearch(){
        System.out.println("All ledger entries from " + "1/1/ " + today.getYear() + " - " + today.getMonthValue() + "/" + today.getDayOfMonth() + "/" + today.getYear() + ": \ndate | time | description | vendor | amount");
        for(Transaction nt: newTransactionMap.values()) {
            String[] dateSplit = nt.getDate().split("-");
            if(Integer.parseInt(dateSplit[0]) == today.getYear()){
                System.out.print("\n" + nt.getDate() + " | " + nt.getTime() + " | " + nt.getDescription() + " | " + nt.getVendor() + " | $" + df.format(nt.getAmount()));
            }
        }
        for(Transaction t: transactionMap.values()){
            String[] dateSplit = t.getDate().split("-");
            if(Integer.parseInt(dateSplit[0]) == today.getYear()){
                System.out.print("\n" + t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | $" + df.format(t.getAmount()));
            }
        }
        System.out.println("\nReturning to main menu...");
        mainMenu();
    }
    //Searches ledger based off of only previous year transactions
    public static void previousYearSearch(){
        int prevYear = today.getYear()-1;
        System.out.println("All ledger entries from " + prevYear + ": \ndate | time | description | vendor | amount");
        for(Transaction nt: newTransactionMap.values()) {
            String[] dateSplit = nt.getDate().split("-");
            if(Integer.parseInt(dateSplit[0]) == prevYear){
                System.out.print("\n" + nt.getDate() + " | " + nt.getTime() + " | " + nt.getDescription() + " | " + nt.getVendor() + " | $" + df.format(nt.getAmount()));
            }
        }
        for(Transaction t: transactionMap.values()){
            String[] dateSplit = t.getDate().split("-");
            if(Integer.parseInt(dateSplit[0]) == prevYear){
                System.out.print("\n" + t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | $" + df.format(t.getAmount()));
            }
        }
        System.out.println("\nReturning to main menu...");
        mainMenu();
    }
    //Searches ledger based off of only given vendor
    public static void vendorSearch(){
        try{
            System.out.print("Please enter the name of the vendor that you would like to search for ('x' to return to main menu'): ");
            String vendorChoice = userInput.nextLine();
            userInput.reset();
            if(vendorChoice.equalsIgnoreCase("x")){
                System.out.println("Returning to main menu...");
                mainMenu();
            }
            else{
                int temp = 0;
                for(Transaction nt: newTransactionMap.values()){
                    if(vendorChoice.equalsIgnoreCase(nt.getVendor())){
                        System.out.print("\n" + nt.getDate() + " | " + nt.getTime() + " | " + nt.getDescription() + " | " + nt.getVendor() + " | $" + df.format(nt.getAmount()));
                    }
                    else{
                        temp++;
                    }
                }
                for(Transaction t: transactionMap.values()){
                    if(vendorChoice.equalsIgnoreCase(t.getVendor())){
                        System.out.print("\n" + t.getDate() + " | " + t.getTime() + " | " + t.getDescription() + " | " + t.getVendor() + " | $" + df.format(t.getAmount()));
                    }
                    else{
                        temp++;
                    }
                }
                if(temp == (transactionMap.size() + newTransactionMap.size())){
                    System.out.println("We could not find any transactions with the vendor \"" + vendorChoice + "\". Please try again!\n");
                    vendorSearch();
                }
                else{
                    System.out.println("Returning to the main menu...");
                    mainMenu();
                }
            }
        }
        catch(Exception inputError){
            System.out.println("There seems to have been an error with your input, please try again!\n");
            vendorSearch();
        }
    }
    public static void customSearch(){
        System.out.println("The custom search will ask you for 5 values to search with, if unknown press 'enter' to skip that value: ");
        System.out.print("Please enter the start date of the range you would like to look through (Ex: 01/11/2000): ");
        String startDate = userInput.nextLine();
        System.out.println("s"+startDate+"e");
        System.out.print("\nPlease enter the end date of the range you would like to look through (Ex: 10/29/2000): ");
        String endDate = userInput.nextLine();
        System.out.print("\nPlease enter the description of your chosen item(s) (Ex: invoice, receipts, etc.): ");
        String descChoice = userInput.nextLine();
        System.out.print("\nPlease enter the vendor of your chosen item(s) (Ex: Amazon, Walmart, etc.): ");
        String vendChoice = userInput.nextLine();
        System.out.print("\nPlease enter the cost amount of your chosen item(s) (Ex: $12.34): $");
        double amount = Double.parseDouble(df.format(userInput.nextDouble()));
        userInput.reset();
    }
}
