package dev.paie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYES")
public class RemunerationEmploye {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="MATRICULE")
	private String matricule;
	
	@ManyToOne
	@JoinColumn(name="ENT_ID")
	private Entreprise entreprise;
	
	@ManyToOne
	@JoinColumn(name="PRF_ID")
	private ProfilRemuneration profilRemuneration;
	
	@ManyToOne
	@JoinColumn(name="GRD_ID")
	private Grade grade;
		
	/**
	 * 
	 */
	public RemunerationEmploye() {
		super();
	}
	
	/**
	 * @param matricule
	 * @param entreprise
	 * @param profilRemuneration
	 * @param grade
	 */
	public RemunerationEmploye(String matricule, Entreprise entreprise, ProfilRemuneration profilRemuneration,
			Grade grade) {
		super();
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMatricule() {
		return matricule;
	}
	
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	
	public Grade getGrade() {
		return grade;
	}
	
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "RemunerationEmploye [id=" + id + ", matricule=" + matricule + ", entreprise=" + entreprise.toString()
				+ ", profilRemuneration=" + profilRemuneration.toString() + ", grade=" + grade.toString() + "]";
	}	
	
	
}
