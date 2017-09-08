package dev.paie.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import dev.paie.config.spring.web.WebAppConfig;

public class WebAppInitializer implements WebApplicationInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(WebAppInitializer.class.getName());

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LOG.info("demarrage du serveur");

		// Initialisation du contexte Spring
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebAppConfig.class);

		// InitialiserDonneesService initDonneesService =
		// webContext.getBean(InitialiserDonneesService.class);
		// initDonneesService.initialiser();

		/*
		 * <servlet> <servlet-name>dispatcher</servlet-name>
		 * <servletclass>org.springframework.web.servlet.DispatcherServlet</
		 * servlet-class> <load-on-startup>1</load-on-startup> </servlet>
		 */
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);

		/*
		 * <servlet-mapping> <servlet-name>dispatcher</servlet-name>
		 * <url-pattern>/mvc/*</url-pattern> </servlet-mapping>
		 */
		dispatcher.addMapping("/mvc/*");

		/*
		 * <listener>
		 * <listenerclass>org.springframework.web.context.ContextLoaderListener<
		 * /listener-class> </listener>
		 */
		servletContext.addListener(new ContextLoaderListener(webContext));
	}
}