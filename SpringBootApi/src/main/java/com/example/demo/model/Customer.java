package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

public class Customer {
    private final UUID id;
    @NotBlank
    private final String name;
    private final String password;

    public Customer(@JsonProperty("id") UUID id, @JsonProperty("name")String name, @JsonProperty("password")String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
