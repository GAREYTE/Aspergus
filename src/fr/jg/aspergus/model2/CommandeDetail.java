package fr.jg.aspergus.model2;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

@Entity
public class CommandeDetail extends Identifiable {
	
	@ManyToOne
	private Commande commande;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)

	private Produit produit;
	
	@Required
	private BigDecimal quantite;
	
	@Depends("produit.prixUnitaire, quantite")
	public BigDecimal getAmount() {
		return getQuantite().multiply(getProduit().getPrixUnitaire());
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantity) {
		this.quantite = quantity;
	}
	
}
