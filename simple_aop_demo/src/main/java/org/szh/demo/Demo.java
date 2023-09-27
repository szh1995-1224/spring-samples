package org.szh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        ICalculator calculator = ctx.getBean(ICalculator.class);
        calculator.add(6, 2);
        calculator.minus(3, 0);
    }
}
