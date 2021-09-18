package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RequestMapping(path = "api/v2/customers")
@RestController
public class CustomerControllerV2 {

    private CustomerService customerService;

    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException(
                "ApiRequestException for customer " + id
        );
    }

    @PostMapping
    void createNewCustomer(@RequestBody @Valid Customer customer) {
        System.out.println("POST request ...");
        System.out.println(customer);
    }

    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE request ...");
        System.out.println(customer);
    }
    @DeleteMapping(path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE request for customer with id " + id);
    }
}
