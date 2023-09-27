package org.szh.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

public class JavaConfig {


    @Bean
    @MyProfile("dev")
    DataSource devDataSource() {
        DataSource ds = new DataSource();
        ds.setUsername("dev");
        ds.setPassword("dev");
        ds.setUrl("jdbc:mysql:///dev");
        return ds;
    }

    @Bean
    @MyProfile("prod")
    DataSource prodDataSource() {
        DataSource ds = new DataSource();
        ds.setUsername("prod");
        ds.setPassword("prod");
        ds.setUrl("jdbc:mysql:///prod");
        return ds;
    }


}
