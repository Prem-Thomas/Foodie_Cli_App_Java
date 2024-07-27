package com.hosanna.foodiecliapp.ui;

import com.hosanna.foodiecliapp.controller.CustomerController;
import com.hosanna.foodiecliapp.exceptions.CustomerExistException;
import com.hosanna.foodiecliapp.exceptions.CustomerNotFoundException;
import com.hosanna.foodiecliapp.model.Customer;
import com.hosanna.foodiecliapp.util.Factory;

import java.io.Console;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu extends  Menu{

    private final CustomerController customerController;

    public CustomerMenu() {
        this.customerController = Factory.getCustomerController();
    }

    @Override
    public void displayMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            while(true){
                displayMenuHeader("WELCOME TO CUSTOMER SECTION");
                System.out.println();
                System.out.println("Please select the option !!");
                System.out.println("----------------------------");
                System.out.println("1. Register (New Customer)");
                System.out.println("2. Login (Existing Customer)");
                System.out.println("3. Search Customer");
                System.out.println("4. Display All Customers");
                System.out.println("5. Update Customer");
                System.out.println("6. Delete Customer");
                System.out.println("7. Exit");

                System.out.println("Please enter Your choice(1-7)");

                int input =  scanner.nextInt();
                switch (input){
                    case 1 -> customerRegisterForm();
                    case 2 -> customerLoginForm();
                    case 3 -> customerSearchForm();
                    case 4 -> displayAllcustomers();
                    case 5 -> customerUpdateForm();
                    case 6 -> deleteCustomerForm();
                    case 7 -> {
                        System.out.println("Thank You, See You again !!!!");
                        super.displayMenu();
                    }
                    default -> System.out.println("Invalid Input. Please Enter the valid input from(1-7)");
                }
            }
        } catch (Exception e){
            System.out.println("Some internal error occurred. Please try again !!");
            displayMenu();
        }
    }

    public void customerRegisterForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please register entering the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name =  scanner.nextLine();
            System.out.println("Enter E-mail");
            String email = scanner.nextLine();

            /*
            Console console = System.readPassword("Enter Password (invisible)");
            System.out.println("console : " + console);
            char[] passwordArray = console.readPassword("Enter Password (invisible)");
            String password = String.valueOf(passwordArray);

             */

            System.out.println("Enter password");
            String password = scanner.nextLine();
            // System.out.println("Id : " + id + " , Name : " + name + " , E-mail : " + email + ", Password :" + password);
            Customer customer = new Customer();
            customer.setId(id)
                    .setName(name)
                    .setEmail(email)
                    .setId(password);

            Customer savedCustomer = customerController.save(customer);
            System.out.println("Customer Registration Successful");
            displayCustomerDetails(savedCustomer);

        }catch (CustomerExistException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Some internal error occured. Please try again!!!!.");
            customerRegisterForm();
        }
    }

    public void customerLoginForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please login entering the following details\n");
            System.out.println("Enter E-mail");
            String email = scanner.nextLine();
            System.out.println("Enter Password");
            String password = scanner.nextLine();
            Customer existingCustomer = customerController.validateCustomerLogin(email,password);
            System.out.println("Login Success :");
            System.out.println("Welcome Mr : " + existingCustomer.getName());

        } catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();
        }
    }
    public void customerSearchForm() {
       try {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Please enter the following details to search for Customer\n");
           System.out.println("Enter Id ");
           String id = scanner.nextLine();
           Customer customer = customerController.getCustomerById(id);
           displayCustomerDetails(customer);
       } catch (CustomerNotFoundException e){
           System.out.println(e.getMessage());
           displayMenu();
       }
    }

    public void displayAllcustomers() {
        List<Customer> customerList = this.customerController.getCustomersList();
        String dashesLine = new String(new char[150]).replace('\0','-');
        displayMenuHeader("Customers");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "id", "name", "Email", "Password");
        System.out.println(dashesLine);
        customerList.forEach(customer -> {
            System.out.printf("%-10s %-30s %-80s %-30s\n", customer.getId(), customer.getName(), customer.getEmail(), "*".repeat(customer.getPassword().length()));
        });
    }

    public  void customerUpdateForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Update entering the following details\n");
            System.out.println("Enter Your Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter E-mail");
            String email = scanner.nextLine();
            System.out.println("Enter Password");
            String password = scanner.nextLine();

            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setEmail(email);
            customer.setPassword(password);

            Customer updatedCustomer = customerController.updateCustomer(customer);
            System.out.println("Customer Updated Successfully");
            displayCustomerDetails(updatedCustomer);
        } catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Some internal error occured. Please try again!!");
            customerUpdateForm();
        }
    }

    public  void deleteCustomerForm(){
        try{
            Scanner scanner =new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Customer\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            customerController.deleteCustomer(id);
            System.out.println("Customer Deleted Successfully");
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();

        }
    }


    public void displayCustomerDetails(Customer customer) {
        displayMenuHeader("Customer Details");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "E-mail", "Password");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %30s\n", customer.getId(), customer.getName(), customer.getEmail(), "*".repeat(customer.getPassword().length()) );
    }

}

/*
 powercfg -energy
 powercfg /batteryreport
 */