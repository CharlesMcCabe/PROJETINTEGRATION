package com.example.demo.Service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.dao.WalletDao;
import com.example.demo.model.Customer;
import com.example.demo.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WalletService {
    private final WalletDao walletDao;

    @Autowired
    public WalletService(@Qualifier("wallet") WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    public int addWallet(Wallet wallet){
        return walletDao.insertWallet(wallet);
    }

    public List<Wallet> getAllWallet(){
        return walletDao.selectAllWallet();
    }

    public Optional<Wallet> getWalletById(UUID id){
        return walletDao.selectWalletById(id);
    }

    public int deleteWallet(UUID id){
        return walletDao.deleteWalletById(id);
    }

    public int updateWallet(UUID id, Wallet newCustomer){
        return walletDao.updateWalletById(id, newCustomer);
    }
}
