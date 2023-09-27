package org.szh.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
//        add(jdbcTemplate);
//        update(jdbcTemplate);
//        delete(jdbcTemplate);
//        query(jdbcTemplate);
//        query2(jdbcTemplate);
//        query3(jdbcTemplate);
//        query4(jdbcTemplate);
//        query5(jdbcTemplate);
//        query6(jdbcTemplate);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
        query7(namedParameterJdbcTemplate);
    }

    private static void query7(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("address","深圳");
        List<User> userList = namedParameterJdbcTemplate.query("select * from user where id > :id and address = :address", map, new BeanPropertyRowMapper<>(User.class));
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }

    private static void query6(JdbcTemplate jdbcTemplate) {
        //查询只能查询一列
        List<String> nameList = jdbcTemplate.queryForList("select name from user where address = ?", String.class, "深圳");
        for (String name: nameList) {
            System.out.println("name = " + name);
        }
    }

    private static void query5(JdbcTemplate jdbcTemplate) {
        String name = jdbcTemplate.queryForObject("select name from user where id = ?", String.class, 10);
        System.out.println("name = " + name);
    }

    private static void query4(JdbcTemplate jdbcTemplate) {
        User user = jdbcTemplate.queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<>(User.class), 10);
        System.out.println("user = " + user);
    }

    private static void query3(JdbcTemplate jdbcTemplate) {
        List<User> userList = jdbcTemplate.query("select * from user where address = ?", new BeanPropertyRowMapper<>(User.class), "深圳");
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }

    private static void query2(JdbcTemplate jdbcTemplate) {
        List<User> userList = jdbcTemplate.query("select * from user where address = ?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                return user;
            }
        }, "深圳");
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }

    private static void query(JdbcTemplate jdbcTemplate) {
        jdbcTemplate.query("select * from user where address = ?", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println(id+"-"+name+"-"+ address);
            }
        },"深圳");
    }

    private static void delete(JdbcTemplate jdbcTemplate) {
        int i = jdbcTemplate.update("delete from user where name = ?;", "zhangsan");
        System.out.println("i = " + i);
    }

    private static void update(JdbcTemplate jdbcTemplate) {
        int i = jdbcTemplate.update("update user set address = ? where name=?", "深圳", "zhangsan");
        System.out.println("i = " + i);
    }

    private static void add(JdbcTemplate jdbcTemplate) {
        int i = jdbcTemplate.update("insert into user (name,address)values (?,?)", "zhangsan", "上海");
        System.out.println("i = " + i);
    }
}
