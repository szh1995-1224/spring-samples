package org.szh.demo;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class CaculatorAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("method = " + method.getName() + "方法开始执行！");
    }
}
