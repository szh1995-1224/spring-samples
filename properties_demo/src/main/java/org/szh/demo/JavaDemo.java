package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println("dataSource = " + dataSource);
    }
}
