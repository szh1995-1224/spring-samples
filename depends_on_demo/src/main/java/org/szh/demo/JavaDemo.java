package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
    }
}
