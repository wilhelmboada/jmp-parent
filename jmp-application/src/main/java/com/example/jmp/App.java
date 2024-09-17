package com.example.jmp;

import com.example.jmp.bankapi.Bank;
import com.example.jmp.cloudbankimpl.RetailBank;
import com.example.jmp.cloudserviceimpl.ServiceImpl;
import com.example.jmp.dto.BankCard;
import com.example.jmp.dto.BankCardType;
import com.example.jmp.dto.Subscription;
import com.example.jmp.dto.User;
import com.example.jmp.service.Service;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        // Create a bank (RetailBank) instance
        Bank retailBank = new RetailBank();

        // Create a user
        User user = new User("John", "Doe", LocalDate.of(1990, 1, 1));

        // Create a bank card for the user (CREDIT type)
        BankCard creditCard = retailBank.createBankCard(user, BankCardType.CREDIT);

        // Create a service instance
        Service service = new ServiceImpl();

        // Subscribe the user with their credit card
        service.subscribe(creditCard);

        // Print subscription information
        Subscription subscription = service.getSubscriptionByBankCardNumber(creditCard.number);
        System.out.println("Subscription found for card number: " + subscription.getBankcardNumber());
        System.out.println("Subscription start date: " + subscription.getStartDate());

        // Add user to the service
        System.out.println("Adding user to service...");
        var users = service.getAllUsers();
        users.add(user);

        // Print all users in the system
        System.out.println("All users:");
        users.forEach(u -> System.out.println(u.getName() + " " + u.getSurname() + ", born on " + u.getBirthday()));

        // Filter subscriptions with a custom condition
        var recentSubscriptions = service.getAllSubscriptionsByCondition(sub -> sub.getStartDate().isAfter(LocalDate.now().minusMonths(1)));
        recentSubscriptions.forEach(sub -> System.out.println("Recent subscription: " + sub.getBankcardNumber()));

    }
}
