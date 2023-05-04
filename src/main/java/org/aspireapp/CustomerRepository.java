package org.aspireapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private List<Customer> customers;

    public CustomerRepository() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Optional<Customer> getCustomerById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    public void updateCustomer(Customer customer) {
        int index = customers.indexOf(customer);
        if (index >= 0) {
            customers.set(index, customer);
        }
    }

    public void deleteCustomer(int id) {
        Optional<Customer> customerById = getCustomerById(id);
        customers.remove(customerById.get());
    }
}
