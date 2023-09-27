package org.szh.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //这个注解的含义 ，就表示去Spring容器中查找相同类型的Bean 并赋值给当前变量
    @Autowired
    UserDao userDao;

    public String hello() {
        return userDao.hello();
    }
}
