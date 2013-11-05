package fr.jg.aspergus.model;

import javax.persistence.*;

import org.openxava.model.*;

@Entity
public class Adresse extends Identifiable{
	
	private Integer cp;
	private String rue;
	private String ville;
	public Integer getCp() {
		return cp;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}


}
