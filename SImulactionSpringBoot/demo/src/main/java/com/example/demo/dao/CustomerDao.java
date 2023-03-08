package com.example.demo.dao;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerDao {
    int insertCustomer(int id, Customer customer);
    default int insertCustomer(Customer customer){
        int id =1;
        return insertCustomer(id, customer);
    }

    List<Customer> selectAllCustomer();
}