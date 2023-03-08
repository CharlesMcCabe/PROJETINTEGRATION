package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Customer {
    private final int id;
    private final String name;
    private final String password;

    public Customer(@JsonProperty("id") int id,
                    @JsonProperty("name")String name,
                    @JsonProperty("password")String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}

