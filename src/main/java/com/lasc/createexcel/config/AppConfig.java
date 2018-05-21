package com.lasc.createexcel.config;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan("com.lasc.createexcel")
@PropertySource("classpath:reports/api-create-excel.properties")
@EnableWebMvc
public class AppConfig {

    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    @PostConstruct
    public void postInitSetup() {
        PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
        log.info("Create excel start...");
    }
}
