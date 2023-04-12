package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

public class Wallet {
    private final UUID id;
    @NotNull
    private final double sold;
    private final UUID idStocks;

    public Wallet(@JsonProperty("id") UUID id, @JsonProperty("amount")double amount, @JsonProperty("idStocks")UUID idStocks) {
        this.id = id;
        this.sold = amount;
        this.idStocks = idStocks;
    }

    public UUID getId() {
        return id;
    }

    public double getSold() {
        return sold;
    }

    public UUID getIdStocks() {
        return idStocks;
    }

}