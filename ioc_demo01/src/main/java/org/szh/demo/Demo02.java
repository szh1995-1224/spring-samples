package org.szh.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02 {

    public static void main(String[] args) {
        //这个容器，就是自动去classpath 下面查找配置文件 并根据该配置文件启动容器
        //这行代码 就是加载spring配置文件，并完成容器初始化
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean_property_inject.xml");
        User user = ctx.getBean("user", User.class);
        System.out.println("user = "+ user);
    }
}
