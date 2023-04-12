package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.model.Wallet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("wallet")
public class WalletDataAccessService implements WalletDao {
    private final List<Wallet> DB = new ArrayList<>();
    @Override
    public int insertWallet(UUID id, Wallet customer) {
        DB.add(new Wallet(id,customer.getSold(), customer.getIdStocks()));
        return 1;
    }

    @Override
    public List<Wallet> selectAllWallet() {
        return DB;
    }

    @Override
    public int deleteWalletById(UUID id) {
        Optional<Wallet> walletMaybe = selectWalletById(id);
        if(walletMaybe.isEmpty()){
            return 0;
        }
        DB.remove(walletMaybe.get());
        return 1;
    }

    @Override
    public int updateWalletById(UUID id, Wallet wallet) {
        return selectWalletById(id)
                .map(p -> {
                    int indexOfCustomerToDelete = DB.indexOf(p);
                    if(indexOfCustomerToDelete >= 0){
                        DB.set(indexOfCustomerToDelete, new Wallet(id, wallet.getSold(), wallet.getIdStocks()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }

    @Override
    public Optional<Wallet> selectWalletById(UUID id) {
        return DB.stream()
                .filter(wallet -> wallet.getId().equals(id))
                .findFirst();
    }
}
