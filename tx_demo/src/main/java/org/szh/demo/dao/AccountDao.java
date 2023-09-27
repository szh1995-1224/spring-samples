package org.szh.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addMoney(String username, Double money) {
        jdbcTemplate.update("update account set money = money + ? where username = ?", money, username);
    }

    public void minusMoney(String username, Double money) {
        jdbcTemplate.update("update account set money = money - ? where username = ?", money, username);
    }
}
