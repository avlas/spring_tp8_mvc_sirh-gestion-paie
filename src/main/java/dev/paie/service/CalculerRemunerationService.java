package dev.paie.service;

import dev.paie.entity.BulletinSalaire;
import dev.paie.entity.ResultatCalculRemuneration;

public interface CalculerRemunerationService {
	
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);
	
}
