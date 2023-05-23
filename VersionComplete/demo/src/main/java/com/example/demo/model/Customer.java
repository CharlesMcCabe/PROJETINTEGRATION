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
    private double solde;
    private String symbole;
    private double averagePrice;
    private int quantityBought;

    public Customer(@JsonProperty("id") UUID id,
                    @JsonProperty("name")String name,
                    @JsonProperty("password")String password,
                    @JsonProperty("solde") double solde,
                    @JsonProperty("symbole")String symbole,
                    @JsonProperty("price")double averagePrice,
                    @JsonProperty("quantity") int quantityBought) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.solde = solde;
        this.symbole = symbole;
        this.averagePrice = averagePrice;
        this.quantityBought = quantityBought;
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

    public double getSolde(){return solde;}

    public String getSymbole(){return symbole;}
    public double getAveragePrice(){return averagePrice;}
    public int getQuantityBought(){return quantityBought;}

}
