package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        //加载 Java 代码配置的容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        User user = ctx.getBean("user", User.class);
        System.out.println("user = " + user);
    }
}
