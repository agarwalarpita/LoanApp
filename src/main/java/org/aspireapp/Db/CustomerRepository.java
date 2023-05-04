package org.aspireapp.Db;

import org.aspireapp.Pojos.Customer;

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

    public String updateCustomer(Customer customer) {
        Optional<Customer> currentCustomer = getCustomerById(customer.getId());
        if(currentCustomer.isPresent()) {
            customers.remove(currentCustomer.get());
            customers.add(customer);
            return "Customer Updated";
        }
        else {
            return "Customer Id invalid";
        }
    }

    public void deleteCustomer(int id) {
        Optional<Customer> customerById = getCustomerById(id);
        customers.remove(customerById.get());
    }
}
