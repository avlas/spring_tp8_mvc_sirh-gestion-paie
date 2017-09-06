package dev.paie.config.spring.data.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("dev.paie.repository")
public class DataJpaConfig {

}
