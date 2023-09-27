package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService1 = ctx.getBean(UserService.class);
        UserService userService2 = ctx.getBean(UserService.class);
        System.out.println("userService1 = " + userService1);
        System.out.println("userService2 = " + userService2);
        UserDao ud1 = ctx.getBean(UserDao.class);
        UserDao ud2 = ctx.getBean(UserDao.class);
        System.out.println("ud1 = " + ud1);
        System.out.println("ud2 = " + ud2);
        System.out.println("userService1.getUserDao() = " + userService1.getUserDao());
        System.out.println("userService2.getUserDao() = " + userService2.getUserDao());

    }
}
