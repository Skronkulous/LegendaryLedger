package com.pluralsight;

import jdk.dynalink.NamedOperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.HashMap;

public class FileManipulation {
    public static HashMap<Integer, Transaction> transactionMap = new HashMap<Integer, Transaction>();
    public static void csvReader(){
        try{
            FileReader fr = new FileReader("src/main/resources/transactions.csv");
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String tempInfo = "";
            int temp = 0;
            while((tempInfo = br.readLine()) != null){
                String[] splitLine = tempInfo.split("\\|");
                String date = (splitLine[0]);
                String time = (splitLine[1]);
                String description = (splitLine[2]);
                String vendor = (splitLine[3]);
                double amount = Double.parseDouble(splitLine[4]);
                Transaction newTransaction = new Transaction(date, time, description, vendor, amount);
                transactionMap.put(temp, newTransaction);
                temp++;
            }
            fr.close();
            br.close();
        }
        catch(Exception fileError){
            System.out.println("There seems to be an issue with the current file path. Please update and try again.");
            fileError.printStackTrace();
        }
    }
    public static void csvWriter(){

    }

    public static String getName(){
        try{
            File temp = new File ("transaction.csv");
            String fp = temp.getAbsolutePath();
            String[] splitLine = fp.split("\\\\");
            return splitLine[2];
        }
        catch (Exception pathError){
            return null;
        }
    }
}
