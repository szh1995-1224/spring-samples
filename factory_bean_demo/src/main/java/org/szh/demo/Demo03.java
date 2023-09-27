package org.szh.demo;

import okhttp3.OkHttpClient;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo03 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        OkHttpClient okHttpClient = ctx.getBean("httpClient2", OkHttpClient.class);
        System.out.println("okHttpClient2 = " + okHttpClient);
        OkHttpClientFactoryBean bean = ctx.getBean(OkHttpClientFactoryBean.class);
        System.out.println("bean = " + bean);
        OkHttpClientFactoryBean bean1 = ctx.getBean("&httpClient2",OkHttpClientFactoryBean.class);
        System.out.println("bean1 = " + bean);
    }
}
