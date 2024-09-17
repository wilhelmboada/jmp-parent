package com.example.jmp.cloudserviceimpl;

import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.Subscription;
import com.example.jmp.dto.User;
import com.example.jmp.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ServiceImpl implements Service {

    private final List<User> users = new ArrayList<>();
    private final List<Subscription> subscriptions = new ArrayList<>();

    @Override
    public void subscribe(BankCard card) {
        Subscription subscription = new Subscription(card.number, LocalDate.now());
        subscriptions.add(subscription);
    }

    @Override
    public Subscription getSubscriptionByBankCardNumber(String number) {
        return subscriptions.stream()
                .filter(subscription -> subscription.getBankcardNumber().equals(number))
                .findFirst()
                .orElseThrow(JMPException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate) {
        return subscriptions.stream()
                .filter(predicate)
                .toList();
    }
}
