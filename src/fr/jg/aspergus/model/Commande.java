package fr.jg.aspergus.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

@Entity
public class Commande extends Identifiable{
	@ManyToOne
	@Required
	@DescriptionsList(descriptionProperties="nom,prenom")
	private Client client;
	@OneToMany(mappedBy="commande",cascade=CascadeType.REMOVE)
	@ListProperties("qte,montant")
	private Collection< LigneCommande> lignes;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Collection<LigneCommande> getLignes() {
		return lignes;
	}
	public void setLignes(Collection<LigneCommande> lignes) {
		this.lignes = lignes;
	}
}
