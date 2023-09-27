package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.szh.demo.service.AccountService;

public class Demo01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        accountService.transferMoney("lisi","zhangsan",100.0);
    }
}
