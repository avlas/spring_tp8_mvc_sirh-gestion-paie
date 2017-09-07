package dev.paie.init.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import dev.paie.init.service.InitialiserDonneesService;

@Controller
public class StartupController {
	
	@Autowired
	private InitialiserDonneesService initService;
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent(){
		initService.initialiser();
	}
	

}
