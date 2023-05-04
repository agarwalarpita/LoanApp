package org.aspireapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerService {
    private List<Customer> customers;
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.customers = new ArrayList<>();
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public Optional<Customer> getCustomerById(int id)  {
        return customerRepository.getCustomerById(id);
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    public void deleteCustomer(int id)  {
        customerRepository.deleteCustomer(id);
    }
}
