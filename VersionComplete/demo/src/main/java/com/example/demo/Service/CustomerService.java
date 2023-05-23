package com.example.demo.Service;

import com.example.demo.dao.Users.CustomerDao;
import com.example.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("user") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public int addCustomer(Customer customer){
        return customerDao.insertCustomer(customer);
    }

    public List<Customer> getAllCustomer(){
        return customerDao.selectAllCustomer();
    }

    public Optional<Customer> getCustomerById(UUID id){
        return customerDao.selectCustomerById(id);
    }

    public int deleteCustomer(UUID id){
        return customerDao.deleteCustomerById(id);
    }

    public int updateCustomer(UUID id, Customer newCustomer){
        return customerDao.updateCustomerById(id, newCustomer);
    }

    public List<Customer> getCustomerByName(String name){return customerDao.selectCustomerByName(name);};

    public int updateCustomerByNameAndSymbol(String name, String symbole, Customer customerToUpdate){
        return customerDao.updateCustomerByNameAndSymbol(name, symbole, customerToUpdate);
    }

    public Optional<Customer> getCustomerByNameAndSymbole(String name, String symbole){
        return customerDao.selectCustomerByNameAndSymbole(name, symbole);
    }



}
