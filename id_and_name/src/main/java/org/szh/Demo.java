package org.szh;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class Demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        User user01 = ctx.getBean("org.szh.User", User.class);
        User user11 = ctx.getBean("org.szh.User#0", User.class);
        User user02 = ctx.getBean("org.szh.User#1", User.class);
        User user03 = ctx.getBean("org.szh.User#2", User.class);
        System.out.println("user01 = " + user01);
        System.out.println("user02 = " + user02);
        System.out.println("user03 = " + user03);
        System.out.println(user01 == user11);

        String split = ",; ";
        String[] strings = StringUtils.tokenizeToStringArray("name1,name2;name3 name4", split);
        for (String string : strings) {
            System.out.println(string);
        }

    }

}
