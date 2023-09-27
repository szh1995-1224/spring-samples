package org.szh.demo;

public class CalculatorImpl implements ICalculator{
    @Override
    public Integer add(int a, int b) {
        System.out.println("a+b = " + a + b);
        return a+b;
    }
}
