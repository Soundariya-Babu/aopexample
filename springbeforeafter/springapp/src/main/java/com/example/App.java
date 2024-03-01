package com.example;

import com.example.service.MyService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MyService myService = context.getBean(MyService.class);

        String input = "Hello, Spring AOP!";
        String result = myService.process(input);

        System.out.println("Final Result: " + result);

        context.close();
    }
}
