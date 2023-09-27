package org.szh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().addActiveProfile("dev");
        ctx.setConfigLocation("beans.xml");
        ctx.refresh();
        DataSource bean = ctx.getBean(DataSource.class);
        System.out.println("bean = " + bean);
    }
}
