package dev.paie.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade")
public class Grade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String code;
	
	@Column
	private BigDecimal nbHeuresBase;
	
	@Column
	private BigDecimal tauxBase;
		
	
	/**
	 * 
	 */
	public Grade() {
		super();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}
	public BigDecimal getTauxBase() {
		return tauxBase;
	}
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((nbHeuresBase == null) ? 0 : nbHeuresBase.hashCode());
		result = prime * result + ((tauxBase == null) ? 0 : tauxBase.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (nbHeuresBase == null) {
			if (other.nbHeuresBase != null)
				return false;
		} else if (!nbHeuresBase.equals(other.nbHeuresBase))
			return false;
		if (tauxBase == null) {
			if (other.tauxBase != null)
				return false;
		} else if (!tauxBase.equals(other.tauxBase))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Grade [id=" + id + ", code=" + code + ", nbHeuresBase=" + nbHeuresBase + ", tauxBase=" + tauxBase + "]";
	}

}
