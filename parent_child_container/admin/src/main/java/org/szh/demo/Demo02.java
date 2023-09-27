package org.szh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.szh.consumer.RoleService;

/**
 * 兄弟容器
 */
public class Demo02 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ClassPathXmlApplicationContext child1 = new ClassPathXmlApplicationContext("consumer_beans.xml");
        ClassPathXmlApplicationContext child2 = new ClassPathXmlApplicationContext("merchant_beans.xml");
        //不允许bean覆盖
        ctx.setAllowBeanDefinitionOverriding(false);
        child1.setParent(ctx);
        child2.setParent(ctx);
        ctx.refresh();
        RoleService bean = child1.getBean(RoleService.class);
        System.out.println("bean = " + bean);
        org.szh.merchant.RoleService bean1 = child2.getBean(org.szh.merchant.RoleService.class);
        System.out.println("bean1 = " + bean1);


    }
}
