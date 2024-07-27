package com.hosanna.foodiecliapp.ui;

import java.util.Scanner;


public class Menu {

    public Menu(){

    }

    public void displayMenu(){
        try{
            Scanner scanner = new Scanner(System.in);
            while(true){
                displayMenuHeader("WELCOME TO FOODIE APP");
                System.out.println();
                System.out.println("Please select the option");
                System.out.println("-------------------------");
                System.out.println("1. Customer Section");
                System.out.println("2. Restaurant Section");
                System.out.println("3. Dishes Section");
                System.out.println("4. Order Section");
                System.out.println("5. Exit");
                System.out.println("Please enter Your choice (1-5");

                int input = scanner.nextInt();

                switch (input) {
                    case 1 -> new CustomerMenu().displayMenu();
                    case 2 -> new RestaurantsMenu().displayMenu();
                    case 3 ->new DishesMenu().displayMenu();
                    case 4 -> new OrdersMenu().displayMenu();
                    case 5 -> {
                        System.out.println("Thanks for choosing Food App, See You Again!!!");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid Input. Please enterthe valid input from (1-7)");
                }
            }
        }catch (Exception e){
            System.out.println("Some internal error occured. Please try again !!");
            e.printStackTrace();
            displayMenu();
        }
    }
    public void displayMenuHeader(String menuHeader){
        printDashLine();
        String spaces = new String (new char[70]).replace('\0',' ');
        System.out.printf("%-70s %-10s %-70s \n", spaces, menuHeader,spaces);
        printDashLine();
    }

    public void printDashLine(){
        String dashesLine = new String(new char[150]).replace('\0','-');
        System.out.println(dashesLine);
    }
}
























  /*  private DishController dishController;
    private CustomerController customerController;
//    private RestaurantController restaurantController;


    public Menu() {
    this.dishController = Factory.getDishController();
    this.customerController = Factory.getCustomerController();
    // this.restauranntController = Factory.getRestaurantController();
    }

    public void displayMainMenu(){
        try {
            Scanner scanner = new Scanner(System.in);
            while(true){
                displayMenuHeader("WELCOME TO SPICIES FOODIE APP");

                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("---------------------------");
                System.out.println("1. Register (New Customer)");
                System.out.println("2. Login  (Existing Customer)");
                System.out.println("3. View Restaurants");
                System.out.println("4. View Dishes ");
                System.out.println("5. Add Restaurant");
                System.out.println("6. Add Dish");
                System.out.println("7. Place Order");
                System.out.println("8. View Orders");
                System.out.println("9. Exit");

                System.out.println("Please enter your choice (1-7)");

                int input = scanner.nextInt();
                switch(input){
                    case 1:
                        customerRegisterForm();
                        break;
                  /*  case 3:
                        displayRestaurants();
                        break; *
                    case 4:
                        displayDishes();
                        break;
                   /* case 5:
                        newRestaurantForm();
                        break;
                    case 6:
                        newDishForm();
                        break;
                    case 7:

                        break;  *
                    case 9:
                        System.out.println("Thanks for choosing SPICIES Foodie APP, See You Again!!");
                        System.exit(0);
                        break;

                    default :
                        System.out.println("Invalid Input. Please enter the valid input from(1 - 7)");
                }
            }
        }catch (Exception e){
            System.out.println("Some internal error occured. Please try again!!");
            e.printStackTrace();
            displayMainMenu();
        }
    }

    private void displayMenuHeader(String menuHeader) {
        String dashesLine = new String(new char[150]).replace('\0', '-');
        System.out.println(dashesLine);
        String spaces = new String(new char[70]).replace('\0', ' ');
        System.out.printf("%-70s %-10s %-70s \n", spaces, menuHeader, spaces);
        System.out.println(dashesLine);
    }

    private void customerRegisterForm()
    {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Pleae register entering the Following Details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter E-mail");
            String email = scanner.nextLine();
            /*Console console = System.console();
        System.out.println("console : " + console);
        char[] passwordArray = console.readPassword("Enter Password (invisible)");
        String password = String.valueOf(passwordArray);    *

            System.out.println("Enter Password");
            String password = scanner.nextLine();
            // System.out.println("Id : " + id + " , Name : " + name + " , E-mail :  " + email + ", Password :" + password);
            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name)
                    .setEmail(email)
                    .setPassword(password);
             /* CustomerRepository customerRepository = new CustomerRepository();
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        CustomerController customerController = new CustomerController(customerService);   *


            Customer savedCustomer1 = customerController.save(customer);
        }catch (CustomerExistException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Some internal error occured. Please try again !");
            customerRegisterForm();
        }

    }
    private void displayDishes(){
        List<Dish> dishesList =this.dishController.getDishList();
        String dashesLine = new String(new char[150]).replace('\0','-');
        displayMenuHeader("Menu Items");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        System.out.println(dashesLine);
        dishesList.forEach(dish -> {
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        });
    } */


