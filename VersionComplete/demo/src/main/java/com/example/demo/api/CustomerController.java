package com.example.demo.api;

import com.electronwill.nightconfig.core.conversion.Path;
import com.example.demo.Service.CustomerService;
import com.example.demo.dao.Users.CustomerDao;
import com.example.demo.model.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//Lien URL pour accéder à la base de donnée
@RequestMapping("api/users")
@RestController
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @CrossOrigin(origins = "*")
    @PostMapping
    public void addCustomer(@Valid @NonNull @RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    @CrossOrigin(origins = "*")
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
    public void updateCustomer(@PathVariable("id") UUID id ,
                               @Valid @NotBlank @RequestBody Customer customerToUpdate){
        customerService.updateCustomer(id, customerToUpdate);
    }

    @PutMapping(path = "/name/{name}/symbole/{symbole}")
    public void updateCustomerByNameAndSymbol(
            @PathVariable("name") String name,
            @PathVariable("symbole") String symbole,
            @Valid @NotBlank @RequestBody Customer customerToUpdate){
        customerService.updateCustomerByNameAndSymbol(name, symbole, customerToUpdate);
    }
    @CrossOrigin(origins = "*")
    @GetMapping (path= "/name/{name}")
    public List<Customer> getCustomerByName(@PathVariable("name") String name){
        return customerService.getCustomerByName(name);
    }
}
