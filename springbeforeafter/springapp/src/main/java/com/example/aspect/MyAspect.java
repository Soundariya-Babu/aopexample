package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    @Before("execution(* com.example.service.MyService.process(..)) && args(input)")
    public void beforeAdvice(String input) {
        System.out.println("Before advice - Input: " + input);
    }

    @AfterReturning(pointcut = "execution(* com.example.service.MyService.process(..))", returning = "result")
    public void afterReturningAdvice(String result) {
        System.out.println("After returning advice - Result: " + result);
    }

    @Around("execution(* com.example.service.MyService.process(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around advice - Before");
        Object result = joinPoint.proceed();
        System.out.println("Around advice - After");
        return "Modified: " + result;
    }
}
