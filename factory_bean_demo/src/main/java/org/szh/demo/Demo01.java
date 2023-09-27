package org.szh.demo;

import okhttp3.OkHttpClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(OkHttpClientStaticFactory.class);
//        OkHttpClient okHttpClient = ctx.getBean(OkHttpClient.class);
//        System.out.println("okHttpClient = " + okHttpClient);
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        OkHttpClient okHttpClient = ctx.getBean("httpClient", OkHttpClient.class);
        System.out.println("okHttpClient = " + okHttpClient);
    }
}
