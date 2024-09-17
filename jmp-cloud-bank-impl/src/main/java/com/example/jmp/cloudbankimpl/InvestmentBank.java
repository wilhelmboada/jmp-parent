package com.example.jmp.cloudbankimpl;

import com.example.jmp.bankapi.Bank;
import com.example.jmp.dto.*;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;

import static com.example.jmp.cloudbankimpl.Utils.generateCardNumber;

public class InvestmentBank implements Bank {

    private final Map<BankCardType, BiFunction<User, String, BankCard>> cardCreators = new EnumMap<>(BankCardType.class);

    public InvestmentBank() {
        cardCreators.put(BankCardType.CREDIT, CreditBankCard::new);
        cardCreators.put(BankCardType.DEBIT, DebitBankCard::new);
    }

    @Override
    public BankCard createBankCard(User user, BankCardType type) {
        BiFunction<User, String, BankCard> cardCreator = cardCreators.get(type);

        if (cardCreator != null) {
            return cardCreator.apply(user, generateCardNumber());
        } else {
            throw new IllegalArgumentException("Unsupported card type: " + type);
        }
    }
}
