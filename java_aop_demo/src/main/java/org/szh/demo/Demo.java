package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        ICalculator calculator = ctx.getBean(ICalculator.class);
        calculator.add(3,4);
        System.out.println(calculator.getClass());
    }
}
