package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class CustomerDataAccessService implements CustomerDao{
    @Override
    public int insertCustomer(UUID id, Customer customer) {
        return 0;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return List.of(new Customer(UUID.randomUUID(), "ADMIN", "123qwe123qwe"));
    }

    @Override
    public int deleteCustomerById(UUID id) {
        return 0;
    }

    @Override
    public int updateCustomerById(UUID id, Customer customer) {
        return 0;
    }

    @Override
    public Optional<Customer> selectCustomerById(UUID id) {
        return Optional.empty();
    }
}
