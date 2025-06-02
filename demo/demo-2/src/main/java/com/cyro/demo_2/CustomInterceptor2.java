package com.cyro.demo_2;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

//@Component
//@Aspect
//public class CustomInterceptor2 {
//
//    @Around("@annotation(com.cyro.demo_2.CustomAnnotation)")
//    public void invoke(ProceedingJoinPoint joinPoint) throws Throwable{
//        System.out.println("do something before actual method");
//
//        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
//
//        if(method.isAnnotationPresent((CustomAnnotation.class))){
//            CustomAnnotation customAnnotation = method.getAnnotation(CustomAnnotation.class);
//            System.out.println("name from annotation: " +  customAnnotation.name());
//        }
//        joinPoint.proceed();
//        System.out.println("do something after actual method");
//    }
//}
