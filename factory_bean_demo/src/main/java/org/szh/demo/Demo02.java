package org.szh.demo;

import okhttp3.OkHttpClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        OkHttpClient okHttpClient = ctx.getBean("httpClient1", OkHttpClient.class);
        System.out.println("okHttpClient1 = " + okHttpClient);
    }
}
