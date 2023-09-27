package org.szh.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class JavaConfig {

    @Bean
    @Scope("prototype")
    public User user() {
        return new User();
    }
}
