package fr.jg.aspergus.model2;

import javax.persistence.*;

import org.openxava.annotations.*;

import fr.jg.aspergus.calculator.*;

@Entity
public class Salarie {

	@Id
	@Required
	@DefaultValueCalculator(value=NextNumberCalculator.class,properties={@PropertyValue(name="table",value="Salarie")})
	private Integer numero;
	@Required
	private String nom;
	@Required
	private Boolean visible;
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	
	
}
