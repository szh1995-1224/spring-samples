package org.szh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.szh.consumer.RoleService;

public class Demo01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("consumer_beans.xml", "merchant_beans.xml");
        //不允许bean覆盖
        ctx.setAllowBeanDefinitionOverriding(false);
        ctx.refresh();
        org.szh.merchant.RoleService bean1 = ctx.getBean(org.szh.merchant.RoleService.class);
        System.out.println("bean1 = " + bean1);
        RoleService bean = ctx.getBean(RoleService.class);
        System.out.println("bean = " + bean);

    }
}
