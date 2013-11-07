package fr.jg.aspergus.model2;
import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

@Entity
public class Categorie extends Identifiable{

	@Required
	@Column(length=40)
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
