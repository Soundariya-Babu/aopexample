package com.example;

// src/main/java/com/example/App.java

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.service.MyService;

public class App {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            MyService myService = context.getBean(MyService.class);

            System.out.println("===== Testing doSomething() =====");
            myService.doSomething();
        }
    }
}
