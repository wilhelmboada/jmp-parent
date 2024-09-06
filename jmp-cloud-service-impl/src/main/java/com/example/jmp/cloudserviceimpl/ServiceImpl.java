package com.example.jmp.cloudserviceimpl;

import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.Subscription;
import com.example.jmp.dto.User;
import com.example.jmp.service.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.List.of;

public class ServiceImpl implements Service {

    List<User> users;

    @Override
    public void subscribe(BankCard bankCard) {
        new Subscription(bankCard.number, LocalDate.now());
    }

    @Override
    public Subscription getSubscriptionByBankCardNumber(String number) {
        List<Subscription> getSubscription = of();
        return getSubscription.stream()
                .filter(subscription -> subscription.getBankcardNumber().equals(number))
                .findFirst()
                .orElseThrow(JMPException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return of();
    }

    public void createUsers() {
        User userOne = new User("John1", "Doe1", LocalDate.of(1990, 1, 1));
        User userTwo = new User("John2", "Doe2", LocalDate.of(1991, 1, 1));
        users = of(userOne, userTwo);
    }
}
