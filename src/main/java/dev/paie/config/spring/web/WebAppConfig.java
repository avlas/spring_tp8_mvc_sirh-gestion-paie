package dev.paie.config.spring.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dev.paie.config.spring.jpa.data.DataJpaConfig;
import dev.paie.config.spring.jpa.orm.JpaConfig;
import dev.paie.config.spring.jpa.orm.jdbc.mysql.MySQLDataSourceConfig;
import dev.paie.config.spring.service.ServicesConfig;

@Configuration
// Active SpringMVC
@EnableWebMvc					
@ComponentScan({"dev.paie.init.controller", "dev.paie.init.service", "dev.paie.web.controller"})
@Import({ ServicesConfig.class, DataJpaConfig.class, JpaConfig.class, MySQLDataSourceConfig.class})
public class WebAppConfig {
	
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
}
