package org.szh.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
//开启@Aspect注解
@EnableAspectJAutoProxy
public class JavaConfig {
}
