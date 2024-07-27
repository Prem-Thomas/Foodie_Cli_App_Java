package com.hosanna.foodiecliapp;

import com.hosanna.foodiecliapp.model.Customer;
import com.hosanna.foodiecliapp.repository.CustomerRepository;
import com.hosanna.foodiecliapp.ui.Menu;
import com.hosanna.foodiecliapp.util.CSVReader;

public class Main {
    public static void main(String[] args) {
        /*CSVReader csvReader = new CSVReader();
        System.out.println(csvReader.readCustomersFromCsv());

         */
      /* CustomerRepository customerRepository = new CustomerRepository();
        System.out.println(customerRepository.getCustomersList());


       */


       Menu menu = new Menu();
        menu.displayMenu();


    }
}
