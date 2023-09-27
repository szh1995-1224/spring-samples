package org.szh.demo;

import org.springframework.stereotype.Repository;

/**
 * Spring中默认提供了
 * @Repository 这个注解一般加载Dao层上
 * @Service 这个注解一般加在Service层上
 * @Controller 这个注解一般加在 Controller层上
 * @Component 对于一些身份不明的Bean,则可以使用这个注解
 *
 *  本质上来说 这四个注解没有太大的差别，基本都是一样的，其他注解都衍生自@Component
 */
@Repository("uc")
public class UserDao {
    public String hello() {
        return "hello component scan";
    }
}
