package dev.paie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ENTREPRISES")
public class Entreprise {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="SIRET")
	private String siret;
	
	@Column(name="DENOMINATION")
	private String denomination;
	
	@Column(name="ADRESSE")
	private String adresse;
	
	@Column(name="URSSAF")
	private String urssaf;
	
	@Column(name="CODE_NAF")
	private String codeNaf;
	
	
	/**
	 * 
	 */
	public Entreprise() {
		super();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getSiret() {
		return siret;
	}
	
	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	public String getDenomination() {
		return denomination;
	}
	
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getUrssaf() {
		return urssaf;
	}
	
	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}
	
	public String getCodeNaf() {
		return codeNaf;
	}
	
	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}

	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", siret=" + siret + ", denomination=" + denomination + ", adresse=" + adresse
				+ ", urssaf=" + urssaf + ", codeNaf=" + codeNaf + "]";
	}
	
	
}