package org.szg.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Dog dog1 = ctx.getBean("dog1", Dog.class);
        Dog dog2 = ctx.getBean("dog2", Dog.class);
        System.out.println("dog1 = " + dog1);
        System.out.println("dog2 = " + dog2);
    }
}
