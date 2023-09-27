package org.szh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        String[] users = ctx.getAliases("user3");
        for (String user : users) {
            System.out.println("alias = " + user);
        }
//        Object user2 = ctx.getBean("user2");
//        Object user3 = ctx.getBean("user3");
//        System.out.println(user3 == user2);
    }
}
