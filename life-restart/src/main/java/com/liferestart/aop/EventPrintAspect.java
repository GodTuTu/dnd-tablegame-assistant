package com.liferestart.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class EventPrintAspect {
    @Pointcut("@annotation(com.liferestart.aop.annotation.EventPrint)")
    private void rdpointcut() {
    }

    @AfterReturning(pointcut = "rdpointcut()", returning = "ret")
    public void afterReturning(JoinPoint joinPoint, boolean ret) throws IllegalArgumentException, IllegalAccessException {
        
    }
}
