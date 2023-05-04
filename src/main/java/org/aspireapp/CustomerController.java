package org.aspireapp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController

public class CustomerController {

    private final CustomerService customerService = new CustomerService( new CustomerRepository());

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable ("id") Integer id) {
        return customerService.getCustomerById(id);

    }

    @PostMapping ("/customer")
    public void createCustomer(@RequestBody Customer customer) {
         customerService.addCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    public String updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);

    }

    @DeleteMapping ("/customer/{id}")
    public void deleteCustomer(@PathVariable ("id") int id) {
        customerService.deleteCustomer(id);

    }
}
