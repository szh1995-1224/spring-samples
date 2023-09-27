package org.szh.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.szh.consumer.RoleService;

/**
 * 父子容器 (子容器可以拿到自己容器和父容器的Bean 如果父容器还有父容器 也可以拿 类似于java的子类可以获取父类的属性 而父容器不可以拿子容器的Bean)
 */
public class Demo03 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext parent = new ClassPathXmlApplicationContext("merchant_beans.xml");
        ClassPathXmlApplicationContext child = new ClassPathXmlApplicationContext("consumer_beans.xml");
        child.setParent(parent);
        child.refresh();
        RoleService bean = child.getBean(RoleService.class);
        System.out.println("bean = " + bean);
        org.szh.merchant.RoleService bean1 = child.getBean(org.szh.merchant.RoleService.class);
        System.out.println("bean1 = " + bean1);
        org.szh.merchant.RoleService bean2 = parent.getBean(org.szh.merchant.RoleService.class);
        System.out.println("bean2 = " + bean2);

    }
}
