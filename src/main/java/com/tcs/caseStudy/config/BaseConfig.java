package com.tcs.caseStudy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({"classpath:com/tcs/caseStudy/application.properties"})
@ComponentScan(basePackages = "com.tcs")
@EnableTransactionManagement
public class BaseConfig {

}
