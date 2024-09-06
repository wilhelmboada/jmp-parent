package com.example.jmp.dto;

import java.time.LocalDate;

public class Subscription {
    String bankcardNumber;
    LocalDate startDate;

    public Subscription(String bankcardNumber, LocalDate startDate) {
        this.bankcardNumber = bankcardNumber;
        this.startDate = startDate;
    }

    public String getBankcardNumber() {
        return bankcardNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
