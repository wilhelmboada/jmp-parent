package com.example.jmp.dto;

public class DebitBankCard extends BankCard {
    public DebitBankCard(User user, String number) {
        this.user = user;
        this.number = number;
    }
}
