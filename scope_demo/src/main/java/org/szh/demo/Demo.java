package org.szh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        User user1 = ctx.getBean("user", User.class);
        User user2 = ctx.getBean("user", User.class);
        System.out.println(user1 == user2);
    }
}
