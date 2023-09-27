package org.szh.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages = "org.szh.demo",useDefaultFilters = true,excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Repository.class,Service.class}))
public class JavaConfig {

}
