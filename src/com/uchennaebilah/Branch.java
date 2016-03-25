package com.uchennaebilah;

import java.util.ArrayList;

/**
 * Created by Uchenna on 3/24/2016.
 */
public class Branch {
    private int branchNumber;
    private String name;
    private String address;
    private ArrayList<Customer> customerList;

    public Branch(int branchNumber, String name, String address) {
        this.branchNumber = branchNumber;
        this.name = name.toLowerCase();
        this.address = address;
        this.customerList = new ArrayList<Customer>();
    }

    public void newCustomer(String name, Double amount, String comment){
        if (!searchBranchForCustomerName(name)) {
            Customer customer = Customer.createCustomer(name);
            customer.addTransaction(amount,comment);
            this.customerList.add(customer);
        }
        else
            System.out.println("Customer already has an account in this branch.");
    }

    public void addCustomerTransaction(String name, Double amount, String comment){
        if (searchBranchForCustomerName(name)) {
            int position = getCustomerPointer(name);
            customerList.get(position).addTransaction(amount,comment);
        }
        else
            System.out.println("Customer not found.");
    }

    private boolean searchBranchForCustomerName(String customer){
        for (int i = 0; i< customerList.size(); i++){
            //System.out.println(customerList.get(i).getName().toLowerCase() + " and " + customer.toLowerCase());
            if (customerList.get(i).getName().toLowerCase().equals(customer.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    private int getCustomerPointer(String customer){
        for (int i = 0; i< customerList.size(); i++){
            if (customerList.get(i).getName().toLowerCase().equals(customer.toLowerCase())){
                return i;
            }
        }
        return -1;
    }

    public static Branch createBranch (int branchNumber,String name, String address){
        return new Branch(branchNumber,name,address);
    }

    public void printBranchAccounts(boolean withTransactions){
        System.out.println("\nBranch Number: " + this.branchNumber);
        System.out.println("Branch Name: " + this.name.toUpperCase());
        System.out.println("Branch Address: " + this.address);
        System.out.println("\nCUSTOMER ACCOUNTS");

        for (int i=0;i<customerList.size();i++){
            if (withTransactions)
                customerList.get(i).printCustomerTransactions();
            else
                System.out.println((i+1) + " ->\t" + customerList.get(i).getName());
        }

        if (customerList.size()==0)
        {
            System.out.println("No customers are signed up at this branch.");
        }
    }

    public void printCustomerAccount(String name){
        if(searchBranchForCustomerName(name)){
            int position = getCustomerPointer(name);
            customerList.get(position).printCustomerTransactions();
        }
        else
            System.out.println("Customer does not exist");

    }

    public int getBranchNumber() {
        return branchNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }
}