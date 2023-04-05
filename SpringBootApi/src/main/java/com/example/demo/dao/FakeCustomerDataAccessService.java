package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class FakeCustomerDataAccessService implements CustomerDao{
    private static List<Customer> DB = new ArrayList<>();
    @Override
    public int insertCustomer(UUID id, Customer customer){
        DB.add(new Customer(id,customer.getName(), customer.getPassword()));
        return 1;
    }

    @Override
    public List<Customer> selectAllCustomer(){
        return DB;
    }

    @Override
    public int deleteCustomerById(UUID id) {
        Optional<Customer> customerMaybe = selectCustomerById(id);
        if(customerMaybe.isEmpty()){
            return 0;
        }
        DB.remove(customerMaybe.get());
        return 1;
    }

    @Override
    public int updateCustomerById(UUID id, Customer update) {
        return selectCustomerById(id)
                .map(p -> {
                    int indexOfCustomerToDelete = DB.indexOf(p);
                    if(indexOfCustomerToDelete >= 0){
                        DB.set(indexOfCustomerToDelete, new Customer(id, update.getName(), update.getPassword()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Customer> selectCustomerById(UUID id) {
        return DB.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }
}
