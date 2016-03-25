package com.uchennaebilah;

import java.util.ArrayList;

/**
 * Created by Uchenna on 3/24/2016.
 */
public class Customer {
    private String name;
    private ArrayList<String> commentList;
    private ArrayList<Double> transactionList;

    public Customer(String name){
        this.name = name.toLowerCase();
        this.transactionList = new ArrayList<Double>();
        this.commentList = new ArrayList<String>();
    }

    public static Customer createCustomer(String name){
        return new Customer(name);
    }

    public void addTransaction(Double amount, String comment){
        this.transactionList.add(amount);
        this.commentList.add(comment);
    }

    public void printCustomerTransactions(){
        System.out.println("\nTransaction History for " + this.name.toUpperCase() + "\n");
        System.out.println("\tNo# \tAmount\t\tDescription");
        for (int i=0; i<this.transactionList.size();i++){
            System.out.println("\t" + (i+1) + " ->" + "\t$" + this.transactionList.get(i)+ "\t\t" + this.commentList.get(i) );
        }

        Double balance = 0.0;

        for (int i=0; i<this.transactionList.size();i++){
            balance += this.transactionList.get(i);
        }

        System.out.println("\nBalance: \t$" + balance);
    }

    public String getName() {
        return this.name.toUpperCase();
    }

}