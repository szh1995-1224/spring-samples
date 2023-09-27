package org.szh.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    User user() {
        User user = new User();
        user.setName("训狗人");
        // @Configuration 注解一般加在项目的配置类上面
        // 因为@Configuration 注解 则调用@Bean注解标记的方法 会先去检查Spring容器中是否存在该Bean 如果存在则直接使用Spring容器中的Bean ,
        // 否则采取创建新的Bean 并且将创建结果保存起来，这样后续就不再创建 该Bean 不会重复注册Bean到Spring容器中
        // 所以其中@Component注解和@Configuration注解的区别就是在这里 @Conponent 注解在上述这种情况中会创建重复的Bean 而@Configuration 不会
        user.setDog(dog());
        return user;
    }

    @Bean
    Dog dog() {
        Dog dog = new Dog();
        dog.setName("小黑");
        dog.setAge(7);
        return dog;
    }


}
