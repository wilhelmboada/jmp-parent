package com.example.jmp;

import com.example.jmp.service.Service;

import java.util.ServiceLoader;

/**
 * Hello world!
 *
 */
public class App {
    ServiceLoader<Service> loader = ServiceLoader.load(Service.class);

    public static void main(String[] args) {
        ServiceLoader<Service> loader = ServiceLoader.load(Service.class);

        for (Service service : loader) {
            System.out.println("Loaded Service Implementation: " + service.getClass().getName());
            // Use the service
        }
    }
}
