package org.szh.demo;

import org.springframework.context.annotation.Bean;

public class JavaConfig {

    @Bean
    public User user(Dog dog) {
        System.out.println("userBeanInit");
        User user = new User();
        user.setName("孙志昊");
        user.setAge(27);
        user.setDog(dog);
        return user;
    }

    @Bean("dog1")
    public Dog dog() {
        System.out.println("dogBeanInit");
        Dog dog = new Dog();
        dog.setName("煤球");
        dog.setColor("黑色");
        return dog;

    }
}
