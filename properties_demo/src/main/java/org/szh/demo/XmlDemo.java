package org.szh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println("dataSource = " + dataSource);
    }
}
