package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        Calculator calculator = ctx.getBean(Calculator.class);
        System.out.println("calculator.getClass() = " + calculator.getClass());
        calculator.add(3,4);
        calculator.minus(3,4);
    }
}
