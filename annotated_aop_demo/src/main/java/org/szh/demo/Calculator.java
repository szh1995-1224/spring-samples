package org.szh.demo;

import org.springframework.stereotype.Component;

@Component
@TimeLog
public class Calculator {

    public int add(int a, int b) {
        System.out.println("a + b = " + (a + b));
        return a + b;
    }
    public void minus(int a, int b) {
        System.out.println("a - b = " + (a - b));
    }
}
