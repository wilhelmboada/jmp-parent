package com.example.jmp.dto;

public class CreditBankCard extends BankCard {
    public CreditBankCard(User user, String number) {
        this.user = user;
        this.number = number;
    }
}
