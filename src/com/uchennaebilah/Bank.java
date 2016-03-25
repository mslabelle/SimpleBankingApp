package com.uchennaebilah;

import java.util.ArrayList;

/**
 * Created by Uchenna on 3/24/2016.
 */
public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public static Bank createBank(String name){
        return new Bank(name);
    }

    public Branch createBranch(int number, String name, String address){
        if (!checkBranch(name)){
            Branch branch = Branch.createBranch(number,name,address);
            this.branches.add(branch);
            return branch;
        }
        else {
            System.out.println("This branch already exists.");
        }
        return null;
    }

    public void createCustomer(Branch branch, String name, Double amount, String comment){
        if (checkBranch(branch))
        {
            int position = getBranchNumber(branch);
            branches.get(position).newCustomer(name,amount, comment);
        }
        else
            System.out.println("Branch doesn't exist.");
    }

    public void newTransaction(Branch branch, String name, Double amount, String comment){
        if (checkBranch(branch))
        {
            int position = getBranchNumber(branch);
            branches.get(position).addCustomerTransaction(name,amount,comment);
        }
        else
            System.out.println("Branch doesn't exist.");
    }

    public void printCustomers(Branch branch, boolean flag){
        if (checkBranch(branch))
        {
            int position = getBranchNumber(branch);
            branches.get(position).printBranchAccounts(flag);
        }
        else
            System.out.println("Branch doesn't exist.");
    }

    public void printCustomerTransaction(Branch branch, String name){
        if (checkBranch(branch))
        {
            int position = getBranchNumber(branch);
            branches.get(position).printCustomerAccount(name);
        }
        else
            System.out.println("Branch doesn't exist.");
    }

    public void printBranches(){
        System.out.println("\nList of branches for " + this.name.toUpperCase() + " bank.\n");
        for (int i=0;i<branches.size();i++){
            System.out.println(branches.get(i).getBranchNumber() + "\t\t" + branches.get(i).getName().toUpperCase() + "\t\t" + branches.get(i).getAddress());
        }
    }

    private boolean checkBranch(String name){
        for (int i = 0; i< branches.size(); i++){
            if (this.branches.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    private boolean checkBranch(Branch name){
        for (int i = 0; i< branches.size(); i++){
            if (this.branches.get(i).getName().toLowerCase().equals(name.getName().toLowerCase())){
                return true;
            }
        }
        return false;
    }

    private int getBranchNumber(Branch name){
        for (int i = 0; i< branches.size(); i++){
            if (this.branches.get(i).getName().toLowerCase().equals(name.getName().toLowerCase())){
                return i;
            }
        }
        return -1;
    }

    public Branch findBranch(String name){
        for (int i = 0; i< branches.size(); i++){
            if (this.branches.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                return branches.get(i);
            }
        }
        return null;
    }
}
