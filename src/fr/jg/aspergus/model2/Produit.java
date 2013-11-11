package fr.jg.aspergus.model2;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import fr.jg.aspergus.calculator.*;

@Entity
public class Produit {
	
	@Id @Column(length=9)
	@DefaultValueCalculator(value=NextNumberCalculator.class,properties={@PropertyValue(name="table",value="Produit")})
	private int numero;
	
	@Column(length=40) @Required
	private String description;
	
	@Required
	@DescriptionsList(descriptionProperties="nom")
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	private Categorie categorie;
	
	@Required
	@Stereotype(value="MONEY")
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}
