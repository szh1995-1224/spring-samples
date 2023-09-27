package org.szh.demo;

import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements ICalculator{
    @Override
    public int add(int a, int b) {
        System.out.println("(a+b) = " + (a + b));
        return a + b;
    }

    @Override
    public void minus(int a, int b) {
        System.out.println("(a-b) = " + (a - b));
    }
}
