package org.szh.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    public static void main(String[] args) {
        //这个容器，就是自动去classpath 下面查找配置文件 并根据该配置文件启动容器
        //这行代码 就是加载spring配置文件，并完成容器初始化
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        Dog dog1 = (Dog) ctx.getBean("dog");
        System.out.println("dog1 = " + dog1);

        Dog dog2 = ctx.getBean(Dog.class);
        System.out.println("dog2 = " + dog2);

//        Dog dog3 = ctx.getBean("dog", Dog.class);
//        System.out.println("dog3 = " + dog3);

//        Dog dog4 = ctx.getBean("dog4", Dog.class);
//        System.out.println("dog4 = " + dog4);
    }
}
