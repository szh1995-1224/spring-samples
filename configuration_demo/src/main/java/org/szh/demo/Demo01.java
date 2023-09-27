package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo01 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        Dog dog = ctx.getBean(Dog.class);
        User user = ctx.getBean(User.class);
        System.out.println("user.getDog() == dog = " + (user.getDog() == dog));
    }
}
