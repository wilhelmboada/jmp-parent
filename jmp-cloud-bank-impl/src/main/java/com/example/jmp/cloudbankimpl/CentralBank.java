package com.example.jmp.cloudbankimpl;

import com.example.jmp.bankapi.Bank;
import com.example.jmp.dto.*;

import java.util.function.Function;

public class CentralBank implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType type) {
        return switch (type) {
            case CREDIT -> new CreditBankCard(user, generateCardNumber());
            case DEBIT -> new DebitBankCard(user, generateCardNumber());
        };
    }

    private String generateCardNumber() {
        return "1234-5678-9012-3456";  // Example card number, you can implement a real generator
    }
}
