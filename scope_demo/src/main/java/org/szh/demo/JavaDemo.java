package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        User user1 = ctx.getBean("user", User.class);
        User user2 = ctx.getBean("user", User.class);
        System.out.println(user1 == user2);
    }
}
