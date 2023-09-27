package org.szh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        UserController uc = ctx.getBean("userController", UserController.class);
        System.out.println("uc.hello() = " + uc.hello());
//        UserService userService = new UserService();
//        userService.hello()
//        UserDao userDao = ctx.getBean("userDao",UserDao.class);
//        System.out.println("userDao = " + userDao);
    }
}
