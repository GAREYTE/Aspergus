package fr.jg.aspergus.model2;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

@Entity
@Views(
		value={@View(members="Client [nom,prenom;"
		+"adresse;"
		+"telephone,email;]"+"commande")})
public class Client {
	
	@Id
	private int number;
	
	@Column(length=40) 
	@SearchKey 
	private String nom;
	
	private String prenom;
	@Embedded
	private Adresse adresse;

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

	public String getNom() {
		return nom;
	}

	public void setNom(String name) {
		this.nom = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNom()+ " "+getPrenom();
	}

	
}
