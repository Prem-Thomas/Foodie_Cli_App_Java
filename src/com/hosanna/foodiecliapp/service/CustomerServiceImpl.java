package com.hosanna.foodiecliapp.service;

import com.hosanna.foodiecliapp.exceptions.CustomerExistException;
import com.hosanna.foodiecliapp.exceptions.CustomerNotFoundException;
import com.hosanna.foodiecliapp.model.Customer;
import com.hosanna.foodiecliapp.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService{
    private Customer currentLoggedInCustomer;

   private  final CustomerRepository customerRepository;
   public CustomerServiceImpl(CustomerRepository customerRepository){
       this.customerRepository = customerRepository;
   }
    @ Override
    public Customer save(Customer customer) throws CustomerExistException {

        // If customer already exists (id, name, email) then throw Customer exits Exception
        // Else save the customerr in the repository
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if(customerById.isPresent())
            throw new CustomerExistException("Customer already exists with this id :"+ customer.getId());
        return this.customerRepository.save(customer);

    }

    @Override
    public List<Customer> getAllCustomers() {
      return  this.customerRepository.getCustomersList();

    }

    @Override
    public Customer getCustomerById(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty())
            throw  new CustomerNotFoundException("Customer Not Found with Id : " + id);

       return customerById.get();
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
       Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
       if(customerById.isEmpty())
           throw new CustomerNotFoundException("Customer Not Found with Id : " + customer.getId());
       return this.customerRepository.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String id) throws  CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer Not Found with Id " + id);
        this.customerRepository.deleteCustomer(customerById.get());

    }

    @Override
    public Customer validateCustomerLogin(String email, String password) throws CustomerNotFoundException {
Optional<Customer> customerById = this.customerRepository.findByEmailAndPassword(email, password);
if(customerById.isEmpty())
    throw  new CustomerNotFoundException("Invalid Email or Password");

        return customerById.get();
    }

    @Override
    public void setCurrentLoggedInCustomer(Customer customer) {
       this.currentLoggedInCustomer = currentLoggedInCustomer;
    }

    @Override
    public Customer getCurrentLoggedInCustomer() {
        return this.currentLoggedInCustomer;
    }
}
