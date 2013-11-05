package fr.jg.aspergus.model2;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Produit {
	
	@Id @Column(length=9)
	private int numero;
	
	@Column(length=40) @Required
	private String description;
	
	@Required
	private BigDecimal prixUnitaire;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int number) {
		this.numero = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal unitPrice) {
		this.prixUnitaire = unitPrice;
	}

}
