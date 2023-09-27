package org.szh.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.szh.demo.dao.AccountDao;

@Service
public class AccountService {
    @Autowired
    AccountDao accountDao;
    @Autowired
    PlatformTransactionManager platformTransactionManager;
    @Autowired
    TransactionTemplate transactionTemplate;

    public void transferMoney(String to, String from, Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    accountDao.minusMoney(from, money);
                    int i = 1 / 0;
                    accountDao.addMoney(to, money);
                } catch (Exception e) {
                    status.setRollbackOnly();
                }
            }
        });
    }

    public void transferMoney2(String to, String from, Double money) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        TransactionStatus status = platformTransactionManager.getTransaction(definition);
        try {
            accountDao.addMoney(to, money);
            int i = 1 / 0;
            accountDao.minusMoney(from, money);
            platformTransactionManager.commit(status);
        } catch (Exception e) {
            platformTransactionManager.rollback(status);
        }
    }
}
