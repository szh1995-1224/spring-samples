package org.szh.demo;

import net.sf.cglib.proxy.Enhancer;

public class CglibDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Calculator.class);
        enhancer.setCallback(new CalculatorProxy());
        Calculator calculator = (Calculator) enhancer.create();
        System.out.println("calculator.getClass() = " + calculator.getClass());
        calculator.minus(7, 3);
    }
}
