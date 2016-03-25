package com.uchennaebilah;

import java.util.Scanner;

public class Main {

    private static Scanner scan = new Scanner(System.in);
    private static Bank halifax = new Bank("Halifax");

    public static void main(String[] args) {
        loadCRS();
        printManual();
        boolean running = true;

        while (running){
            int choice = userInput();
            System.out.println("User Manual");
            System.out.println("0   <--     Show Manual");
            System.out.println("1   <--     Create New Branch");
            System.out.println("2   <--     Create New Customer");
            System.out.println("3   <--     Add Transaction for a customer");
            System.out.println("4   <--     Show Customer Transaction");
            System.out.println("5   <--     Show List of Branches");
            System.out.println("6   <--     List Customers at a Branch");
            System.out.println("7   <--     Show ALL Customer Transactions at a Branch");
            System.out.println("8   <--     Exit CRS");
            switch (choice){
                case 0:
                    printManual();
                    break;

                case 1:
                    newBranch();
                    break;

                case 2:
                    newCustomer();
                    break;

                case 3:
                    newTransaction();
                    break;

                case 4:
                    showCustomerTransactions();
                    break;

                case 5:
                    listOfBranches();
                    break;

                case 6:
                    branchCustomers();
                    break;

                case 7:
                    allCustomerTransactionsInBranch();
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting CRS. Goodbye!");
                    break;

                default:
                    if (choice <= 0)
                        System.out.println("Please enter digits only. Try again.");
                    else
                        System.out.println("Invalid Input. Try again.");
            }
        }
    }

    public static void loadCRS(){
        System.out.println("Welcome to Halifax Bank - CRS");
        System.out.println("-----------------------------");
    }

    public static int userInput(){
        int input;

        System.out.println("Enter choice:");
        input = intInput();
        return input;
    }

    public static void printManual(){
        System.out.println("User Manual");
        System.out.println("0   <--     Show Manual");
        System.out.println("1   <--     Create New Branch");
        System.out.println("2   <--     Create New Customer");
        System.out.println("3   <--     Add Transaction for a customer");
        System.out.println("4   <--     Show Customer Transaction");
        System.out.println("5   <--     Show List of Branches");
        System.out.println("6   <--     List Customers at a Branch");
        System.out.println("7   <--     Show ALL Customer Transactions at a Branch");
        System.out.println("8   <--     Exit CRS");
    }

    public static int intInput(){
        int input;

        try {
            input = scan.nextInt();
        }
        catch (Exception e)
        {
            input = -1;
        }

        scan.nextLine();
        return input;
    }

    public static void newBranch(){
        int branchNumber;
        String branchName;
        String branchAddress;

        System.out.println("Enter Branch ID Number: ");
        branchNumber = intInput();

        if (branchNumber == -1)
        {
            System.out.println("Wrong ID Number.\nReturning to main menu.");
            return;
        }

        else {
            System.out.println("Enter Branch Name: ");
            branchName = scan.nextLine();

            System.out.println("Enter Branch Address: ");
            branchAddress = scan.nextLine();

            halifax.createBranch(branchNumber, branchName, branchAddress);
        }
    }

    public static void newCustomer(){
        System.out.println("Enter the Branch Name: ");
        String branchName = scan.nextLine();

        Branch thisBranch = halifax.findBranch(branchName);

        if (thisBranch != null) {
            System.out.println("Enter new Customer name: ");
            String name = scan.nextLine();

            System.out.println("Enter transaction amount: ");
            Double amount = scan.nextDouble();

            scan.nextLine();

            System.out.println("Enter description of this transaction: ");
            String comment = scan.nextLine();

            halifax.createCustomer(thisBranch,name,amount,comment);
        }
        else
            System.out.println("Branch is invalid.");
    }

    public static void newTransaction(){
        System.out.println("Enter the Branch Name: ");
        String branchName = scan.nextLine();

        Branch thisBranch = halifax.findBranch(branchName);

        if (thisBranch != null) {
            System.out.println("Enter current customer's name: ");
            String name = scan.nextLine();

            System.out.println("Enter transaction amount: ");
            Double amount = scan.nextDouble();

            scan.nextLine();

            System.out.println("Enter description of this transaction: ");
            String comment = scan.nextLine();

            halifax.newTransaction(thisBranch,name,amount,comment);
        }
        else
            System.out.println("Branch is invalid.");
    }

    public static void showCustomerTransactions(){
        System.out.println("Enter the Branch Name: ");
        String branchName = scan.nextLine();

        Branch thisBranch = halifax.findBranch(branchName);

        if (thisBranch != null) {
            System.out.println("Enter current customer's name: ");
            String customer = scan.nextLine();

            halifax.printCustomerTransaction(thisBranch,customer);
        }
        else
            System.out.println("Branch is invalid.");
    }

    public static void listOfBranches(){
        halifax.printBranches();
    }

    public static void branchCustomers(){
        System.out.println("Enter the Branch Name: ");
        String branchName = scan.nextLine();

        Branch thisBranch = halifax.findBranch(branchName);

        if (thisBranch != null) {
            halifax.printCustomers(thisBranch,false);
        }
        else
            System.out.println("Branch is invalid.");
    }

    public static void allCustomerTransactionsInBranch(){
        System.out.println("Enter the Branch Name: ");
        String branchName = scan.nextLine();

        Branch thisBranch = halifax.findBranch(branchName);

        if (thisBranch != null) {
            halifax.printCustomers(thisBranch,true);
        }
        else
            System.out.println("Branch is invalid.");
    }
}
