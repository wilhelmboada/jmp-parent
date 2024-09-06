package com.example.jmp.service;

import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.Subscription;
import com.example.jmp.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public interface Service {

    void subscribe(BankCard bankCard);

    Subscription getSubscriptionByBankCardNumber(String number);

    List<User> getAllUsers();

    default double getAverageUsersAge() {
        LocalDate now = LocalDate.now();
        return getAllUsers().stream()
                .mapToLong(user -> ChronoUnit.YEARS.between(user.getBirthday(), now))  // Calculate age in years
                .average()  // Calculate the average
                .orElse(0);
    }

    static boolean isPayableUser(User user) {
        LocalDate now = LocalDate.now();
        return ChronoUnit.YEARS.between(user.getBirthday(), now) >= 18;
    }
}
