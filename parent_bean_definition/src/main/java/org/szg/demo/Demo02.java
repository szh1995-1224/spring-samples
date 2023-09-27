package org.szg.demo;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // 关于Bean的配置  都会被先解析为BeanDifinition
        //RootBeanDifinition 定义通用的Bean属性
        RootBeanDefinition pbd = new RootBeanDefinition();
        pbd.setBeanClass(Animal.class);
        MutablePropertyValues pValues = new MutablePropertyValues();
        pValues.addPropertyValue("category", "猫科");
        pbd.setPropertyValues(pValues);
        ctx.registerBeanDefinition("parent", pbd);
        //定义特殊的Bean属性
        GenericBeanDefinition cbd = new GenericBeanDefinition();
        cbd.setBeanClass(Cat.class);
        MutablePropertyValues cValues = new MutablePropertyValues();
        cValues.addPropertyValue("name","小花");
        cValues.addPropertyValue("color","五颜六色");
        cbd.setPropertyValues(cValues);
        cbd.setParentName("parent");
        ctx.registerBeanDefinition("child",cbd);
        ctx.refresh();
        Cat bean = ctx.getBean(Cat.class);
        System.out.println("bean = " + bean);
    }
}
