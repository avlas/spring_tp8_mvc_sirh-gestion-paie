package dev.paie.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entity.BulletinSalaire;
import dev.paie.entity.Periode;
import dev.paie.entity.RemunerationEmploye;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationServiceSimple;

@Controller
@RequestMapping("/bulletins")
@Transactional
public class BulletinSalaireController {

	@Autowired
	private PeriodeRepository periodeRepository;
	
	@Autowired
	private RemunerationEmployeRepository remunerationEmployeRepository;

	@Autowired
	private BulletinSalaireRepository bulletinSalaireRepository;
	
	@Autowired
	CalculerRemunerationServiceSimple calculerRemunerationService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/create")
	public ModelAndView createBulletin() {
		List<Periode> periodes = new ArrayList<>();
		Set<String> matricules = new HashSet();	
		
		ModelAndView mv = new ModelAndView();
		for ( Periode periode :  periodeRepository.findAll()) {	
			periodes.add(periode);
		}
		
		for (RemunerationEmploye remunerationEmploye :  remunerationEmployeRepository.findAll()) {	
			matricules.add(remunerationEmploye.getMatricule());
		}
		
		mv.addObject("periodes", periodes);	
		mv.addObject("matricules", matricules);
		
		mv.setViewName("bulletins/createBulletin");

		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/create")
	public ModelAndView doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RemunerationEmploye remunerationEmploye = remunerationEmployeRepository.findByMatricule(request.getParameter("matriculeId"));
		
		Periode periode = periodeRepository.findOne(new Integer(request.getParameter("periodeId")));
		
		BulletinSalaire bulletinSalaire = new BulletinSalaire(remunerationEmploye, periode, BigDecimal.valueOf(Double.parseDouble(request.getParameter("prime"))), LocalDateTime.now());
		bulletinSalaireRepository.save(bulletinSalaire);
		
		return listBulletins();
	
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/list")
	public ModelAndView listBulletin() {
		return listBulletins();
	}
	
	protected ModelAndView listBulletins() {
		ModelAndView mv = new ModelAndView();
		
		List <BulletinSalaire> bulletinSalaires = bulletinSalaireRepository.findAll();
		
		for (BulletinSalaire bulletinSalaire : bulletinSalaires) {			
			bulletinSalaire.setResultatCalculRemuneration(calculerRemunerationService.calculer(bulletinSalaire));
			System.out.println(bulletinSalaire.toString());
		}
	
		mv.addObject("bulletinSalaires", bulletinSalaires);
		
		mv.setViewName("bulletins/listBulletin");
		return mv;
	}
}
