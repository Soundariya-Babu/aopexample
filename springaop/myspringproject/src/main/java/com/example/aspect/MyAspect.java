package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.example.service.MyService.doSomething())")
    public void beforeAdvice() {
        System.out.println("Before advice: Executing before doSomething()");
    }

    @After("execution(* com.example.service.MyService.doSomething())")
    public void afterAdvice() {
        System.out.println("After advice: Executing after doSomething()");
    }

    @Around("execution(* com.example.service.MyService.doSomething())")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around advice: Executing before doSomething()");
        Object result = joinPoint.proceed();
        System.out.println("Around advice: Executing after doSomething()");
        return result;
    }
}
