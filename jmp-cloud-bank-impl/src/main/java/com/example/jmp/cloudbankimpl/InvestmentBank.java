package com.example.jmp.cloudbankimpl;

import com.example.jmp.bankapi.Bank;
import com.example.jmp.dto.*;

public class InvestmentBank implements Bank {
    @Override
    public BankCard createBankCard(User user, BankCardType type) {
        switch (type) {
            case CREDIT:
                return new CreditBankCard(user, generateCardNumber());
            case DEBIT:
                return new DebitBankCard(user, generateCardNumber());
            default:
                throw new IllegalArgumentException("Unsupported card type: " + type);
        }
    }

    private String generateCardNumber() {
        return "1234-5678-9012-3456";  // Example card number, you can implement a real generator
    }
}
