package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.model.Wallet;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface WalletDao {
    int insertWallet(UUID id, Wallet customer);
    default int insertWallet(Wallet wallet){
        UUID id = UUID.randomUUID();
        return insertWallet(id, wallet);
    }

    List<Wallet> selectAllWallet();

    int deleteWalletById(UUID id);

    int updateWalletById(UUID id, Wallet wallet);

    Optional<Wallet> selectWalletById(UUID id);

}
