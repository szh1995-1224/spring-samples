package org.szh.demo;

public aspect TxAspect {
    void around():call(void MoneyService.transferAccount()){
        System.out.println("开启事务");
        try {
            proceed();
            System.out.println("提交事务");
        } catch (Exception e) {
            System.out.println("回滚事务");
        }
    }
}
