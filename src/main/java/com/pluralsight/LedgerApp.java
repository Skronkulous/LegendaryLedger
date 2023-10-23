package com.pluralsight;

import static com.pluralsight.FileManipulation.csvReader;
import static com.pluralsight.FileManipulation.getName;
import static com.pluralsight.MenuMethods.mainMenu;

public class LedgerApp {
    public static void main(String[] args) {
        csvReader();
        System.out.println("Welcome to the Legendary Ledger. Hello " + getName() + ". How can we help you today?");
        mainMenu();
    }
}
