package dev.paie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration											// Marque un bean de configuration Spring
@ImportResource("classpath:jdd-config.xml")				// Import de la configuration XML dans une configuration Java
public class JeuxDeDonneesConfig {

}
