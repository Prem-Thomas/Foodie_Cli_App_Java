package com.hosanna.foodiecliapp.repository;

import com.hosanna.foodiecliapp.model.Customer;
import com.hosanna.foodiecliapp.util.CSVReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private List<Customer> customerList;

    public CustomerRepository(){
        CSVReader csvReader = new CSVReader();
        this.customerList = csvReader.readCustomersFromCsv();
    }

    public List<Customer> getCustomersList(){
        return this.customerList;
    }

    public Customer save(Customer customer){
        this.customerList.add(customer);
        return customer;
    }

    // Customer data  available or not
    public Optional<Customer> findCustomerById(String id){
       return this.customerList.stream().filter(customer ->customer.getId().equals(id)).findFirst();
    }

    public Optional<Customer> findCustomerByEmail(String email){
        return this.customerList.stream().filter(customer -> customer.getEmail().equals(email)).findFirst();
    }

    public Customer updateCustomer(Customer customerToBeUpdated){
        Optional<Customer> updateCustomer = this.customerList.stream().filter(customer ->customer.getId().equals(customerToBeUpdated)).findFirst()
                .map(customer -> {
                    customer.setName(customerToBeUpdated.getName())
                            .setName(customerToBeUpdated.getEmail())
                            .setPassword(customerToBeUpdated.getPassword());
               return customer;
                });
        return updateCustomer.orElse(null);
    }

    public void deleteCustomer(Customer customer){
        this.customerList.remove(customer);
    }

    public Optional<Customer> findByEmailAndPassword (String email, String password){
        return this.customerList.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equals(password)).findFirst();
    }
    // dish , restuarant methods
}
