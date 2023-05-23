package com.example.demo.dao.Users;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

@Repository("user")
public class CustomerDataAccessService implements CustomerDao {
    private static List<Customer> DB = new ArrayList<>();
    private Map<String, List<Customer>> usersByName = new HashMap<>();
    @Override
    public int insertCustomer(UUID id, Customer customer){
        DB.add(new Customer(id,customer.getName(), customer.getPassword(), customer.getSolde(),customer.getSymbole(),customer.getAveragePrice(),customer.getQuantityBought()));
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
                        DB.set(indexOfCustomerToDelete, new Customer(id, update.getName(), update.getPassword(),update.getSolde(), update.getSymbole(),update.getAveragePrice(),update.getQuantityBought()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public int updateCustomerByNameAndSymbol(String name, String symbole, Customer update) {
        UUID id = UUID.randomUUID();
        return selectCustomerByNameAndSymbole(name,symbole)
                .map(p -> {
                    int indexofCustomerToDelete = DB.indexOf(p);
                    if(indexofCustomerToDelete >= 0){
                        DB.set(indexofCustomerToDelete, new Customer(id, name, update.getPassword(),update.getSolde(), symbole,update.getAveragePrice(),update.getQuantityBought()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Customer> selectCustomerByNameAndSymbole(String name, String symbole) {
        return DB.stream()
                .filter(customer -> customer.getName().equals(name))
                .filter(customer -> customer.getSymbole().equals(symbole))
                .findFirst();
    }

    @Override
    public Optional<Customer> selectCustomerById(UUID id) {
        return DB.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Customer> selectCustomerByName(String name) {
        List<Customer> usersWithSameName = DB.stream()
                .filter(user -> user.getName().equals(name))
                .collect(Collectors.toList());
        return usersWithSameName;
    }


}
