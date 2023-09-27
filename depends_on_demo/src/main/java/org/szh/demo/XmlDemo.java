package org.szh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlDemo {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("beans.xml");
    }
}
