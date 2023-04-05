package com.example.demo.api;

import com.example.demo.Service.CustomerService;
import com.example.demo.model.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/users")
@RestController
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping
    public void addCustomer(@Valid @NonNull @RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping(path = "{id}")
    public Customer getCustomerById(@PathVariable("id") UUID id){
        return customerService.getCustomerById(id)
                .orElse(null);
    }
    @DeleteMapping(path="{id}")
    public void deleteCustomerById(@PathVariable("id") UUID id){
        customerService.deleteCustomer(id);
    }

    @PutMapping(path = "{id}")
    public void updateCustomer(@PathVariable("id") UUID id ,@Valid @NotBlank @RequestBody Customer customerToUpdate){
        customerService.updateCustomer(id, customerToUpdate);
    }
}
