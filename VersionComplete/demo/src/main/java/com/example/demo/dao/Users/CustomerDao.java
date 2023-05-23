package com.example.demo.dao.Users;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDao {
    int insertCustomer(UUID id, Customer customer);
    default int insertCustomer(Customer customer){
        UUID id = UUID.randomUUID();
        return insertCustomer(id, customer);
    }

    List<Customer> selectAllCustomer();

    int deleteCustomerById(UUID id);

    int updateCustomerById(UUID id, Customer customer);

    Optional<Customer> selectCustomerById(UUID id);

    List<Customer> selectCustomerByName(String name);

    int updateCustomerByNameAndSymbol(String name, String symbole, Customer customerToUpdate);

    Optional<Customer> selectCustomerByNameAndSymbole(String name, String symbole);
}
