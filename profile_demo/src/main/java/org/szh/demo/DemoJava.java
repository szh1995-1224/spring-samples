package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoJava {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().addActiveProfile("prod");
        ctx.register(JavaConfig.class);
        ctx.refresh();
        DataSource bean = ctx.getBean(DataSource.class);
        System.out.println("bean = " + bean);
    }
}
