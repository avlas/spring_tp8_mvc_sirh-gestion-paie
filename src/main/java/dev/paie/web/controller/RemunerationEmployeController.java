package dev.paie.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entity.Entreprise;
import dev.paie.entity.Grade;
import dev.paie.entity.ProfilRemuneration;
import dev.paie.entity.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;			
	// EntrepriseRepository entrepriseRepository = new EntrepriseRepository ();
	
	@Autowired
	private ProfilRemunerationRepository profilRepository;
	
	@Autowired
	private GradeRepository gradeRepository;
	
	@RequestMapping(method = RequestMethod.GET, path = "/create")
	public ModelAndView createEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("entreprises", entrepriseRepository.findAll());
		mv.addObject("profils", profilRepository.findAll());
		mv.addObject("grades", gradeRepository.findAll());
		mv.setViewName("employes/createEmploye");

		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/create")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Entreprise entreprise = entrepriseRepository.findOne(new Integer(request.getParameter("entrepriseId")));
		ProfilRemuneration profil = profilRepository.findOne(new Integer(request.getParameter("profilId")));
		Grade grade = gradeRepository.findOne(new Integer(request.getParameter("gradeId")));
		
		RemunerationEmploye remunerationEmploye = new RemunerationEmploye(request.getParameter("matricule"), entreprise, profil, grade);
		remunerationEmployeRepository.save(remunerationEmploye);
		
		return listEmployes();
	
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/list")
	public ModelAndView listEmploye() {
		return listEmployes();
	}
	
	protected ModelAndView listEmployes() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("employes", remunerationEmployeRepository.findAll());
		mv.setViewName("employes/listEmploye");
		return mv;
	}
}
