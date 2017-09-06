package dev.paie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import dev.paie.config.spring.data.jpa.DataJpaConfig;
import dev.paie.config.spring.jdbc.mysql.MySQLDataSourceConfig;
import dev.paie.config.spring.orm.jpa.JpaConfig;

@Configuration
@ComponentScan(basePackages = { "dev.paie.service", "dev.paie.util" })
@Import({ DataJpaConfig.class, MySQLDataSourceConfig.class,  JpaConfig.class })
public class ServicesConfig {
}