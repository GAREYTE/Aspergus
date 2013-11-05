package fr.jg.aspergus.model2;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
public class Client {
	
	@Id
	private int number;
	
	@Column(length=40) 
	@SearchKey 
	private String name;
	
	private String prenom;
	
	private String adresse;
	
	private String codePostal;
	
	private String ville;
	@Stereotype(value="TELEPHONE")
	private String telephone;
	@Stereotype(value="EMAIL")
	private String email;
	
	@OneToMany(mappedBy="client", cascade=CascadeType.REMOVE)
	private Collection<Commande> commande;
	
	public Collection<Commande> getCommande() {
		return commande;
	}

	public void setCommande(Collection<Commande> commande) {
		this.commande = commande;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	
}
