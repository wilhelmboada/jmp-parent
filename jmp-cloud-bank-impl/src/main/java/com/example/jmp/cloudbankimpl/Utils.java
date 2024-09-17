package com.example.jmp.cloudbankimpl;

import java.util.Random;

public class Utils {

    public static String generateCardNumber() {
        return new Random().nextInt(10) + "";
    }
}
