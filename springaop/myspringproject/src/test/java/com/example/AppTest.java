package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.MyService;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testDoSomethingWithAspect() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
            MyService myService = context.getBean(MyService.class);

            System.out.println("===== Testing doSomething() =====");
            myService.doSomething();

            // Check the console output
            String actualOutput = outContent.toString();

            // Assert relevant parts of the output
            assertTrue(actualOutput.contains("Before advice: Executing before doSomething()"));
            assertTrue(actualOutput.contains("Around advice: Executing before doSomething()"));
            assertTrue(actualOutput.contains("Executing the actual method: doSomething()"));
            assertTrue(actualOutput.contains("Around advice: Executing after doSomething()"));
            assertTrue(actualOutput.contains("After advice: Executing after doSomething()"));

        }
    }
}
