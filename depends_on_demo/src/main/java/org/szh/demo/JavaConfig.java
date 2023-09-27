package org.szh.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

public class JavaConfig {

    @Bean
    @DependsOn("a")
    public B b() {
        return new B();
    }

    @Bean
    public A a() {
        return new A();
    }


}
