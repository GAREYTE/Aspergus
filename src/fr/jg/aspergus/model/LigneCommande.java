package fr.jg.aspergus.model;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;
@Entity

public class LigneCommande extends Identifiable{
	@Required
	private BigDecimal qte;
	@ManyToOne
	@DescriptionsList(descriptionProperties="nom")
	private Categorie categorie;
	@Required
	private BigDecimal montant;
	@ManyToOne()
	private Commande commande;
	
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public BigDecimal getQte() {
		return qte;
	}
	public void setQte(BigDecimal qte) {
		this.qte = qte;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public BigDecimal getMontant() {
		return montant;
	}
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}
}
