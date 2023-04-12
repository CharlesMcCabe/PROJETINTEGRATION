package com.example.demo.api;

import com.example.demo.Service.WalletService;
import com.example.demo.model.Wallet;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RequestMapping("api/wallet")
@RestController
public class WalletController {
    private final WalletService walletService;
    @Autowired
    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }

    @PostMapping
    public void addWallet(@Valid @NonNull @RequestBody Wallet wallet){
        walletService.addWallet(wallet);
    }

    @GetMapping
    public List<Wallet> getAllWallet(){
        return walletService.getAllWallet();
    }

    @GetMapping(path = "{id}")
    public Wallet getWalletById(@PathVariable("id") UUID id){
        return walletService.getWalletById(id).orElse(null);
    }
    @DeleteMapping(path="{id}")
    public void deleteWalletById(@PathVariable("id") UUID id){
        walletService.deleteWallet(id);
    }

    @PutMapping(path = "{id}")
    public void updateWallet(@PathVariable("id") UUID id ,@Valid @NotBlank @RequestBody Wallet walletToUpdate){
        walletService.updateWallet(id, walletToUpdate);
    }
}
