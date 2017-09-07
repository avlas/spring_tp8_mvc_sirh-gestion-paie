package dev.paie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="profil_remuneration")
public class ProfilRemuneration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String code;

	@OneToMany
	@JoinColumn(foreignKey = @ForeignKey(name="FK_PROFIL_RENUM_COT_NONIMPO_ID"))
	private List<Cotisation> cotisationsNonImposables;
	
	@OneToMany
	@JoinColumn(foreignKey = @ForeignKey(name="FK_PROFIL_RENUM_COT_IMPO_ID"))
	private List<Cotisation> cotisationsImposables;
	
	@OneToMany
	@JoinColumn(foreignKey = @ForeignKey(name="FK_PROFIL_AVANTAGE_ID"))
	private List<Avantage> avantages;

	/**
	 * 
	 */
	public ProfilRemuneration() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
