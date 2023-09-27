package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserController uc = ctx.getBean("userController", UserController.class);
        System.out.println("uc.hello() = " + uc.hello());
//        UserService userService = new UserService();
//        userService.hello()
//        UserDao userDao = ctx.getBean("userDao",UserDao.class);
//        System.out.println("userDao = " + userDao);
    }
}
