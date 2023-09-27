package org.szh.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//将配置文件注册到Spring容器中去 ，作用类似于 <context:property-placeholder location="classpath:db.properties" />
@PropertySource("classpath:db.properties")
public class JavaConfig {
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.url}")
    private String url;

    @Bean
    DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }
}
