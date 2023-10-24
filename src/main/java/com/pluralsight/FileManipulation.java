package com.pluralsight;

import java.io.*;
import java.util.HashMap;

import static com.pluralsight.PaymentMethods.df;
import static com.pluralsight.PaymentMethods.newTransactionMap;

public class FileManipulation {
    public static HashMap<Integer, Transaction> transactionMap = new HashMap<Integer, Transaction>();
    //instantiates the map of transactions for the objects in the csv to be written onto (set public so other classes can access)
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
        //csvReader method will read the csv file and input it into a Hashmap of transactions (file error exception if pathing is off)
    }
    public static void csvWriter(){
        try{
            FileWriter fw = new FileWriter("src/main/resources/transactions.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Transaction t: newTransactionMap.values()){
                String tempString = (t.getDate().trim() + "|" + t.getTime().trim() + "|" + t.getDescription().trim() + "|" + t.getVendor().trim() + "|" + df.format(t.getAmount()).trim());
                bw.write(tempString);
                bw.newLine();
            }
            bw.close();
        }
        catch(Exception fileError){
            System.out.println("There seems to have been an issue with the file path. Please update and try again.");
            fileError.printStackTrace();
        }
    }
    //csvWriter will read the new transaction map and append it to the csv file

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
    //this will grab the name of the User folder on the local machine
}
