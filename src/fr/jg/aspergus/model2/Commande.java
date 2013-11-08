package fr.jg.aspergus.model2;

import java.math.*;
import java.util.*;

import javax.persistence.*;
import javax.xml.ws.soap.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.model.*;

import fr.jg.aspergus.calculator.*;

@Entity
@Views({
	@View(members=" Entête [annee, numero, tva];" +
		"Préparation [dateCommande,prisePar;datePreparation,preparePar;dateLivraison,livrePar;]"+
		"client;" +
		"details;" +
		"remarque"
	),
	@View(name="WithSections", members=
		"annee, numero, dateCommande, tva;" +
		"client { client }" +
		"details { details }" +
		"remarque { remarque } "			
	)	
})
@Tab(properties="annee, numero, dateCommande, client.nom, remarque")
public class Commande extends Identifiable {
	
	@DefaultValueCalculator(CurrentYearCalculator.class)
	@Column(length=4) @Required
	private int annee;
	
	@Column(length=6) @Required	
	@DefaultValueCalculator(value=NextNumberCommandeCalculator.class,properties={@PropertyValue(name="annee")})
	private Integer numero;
	
	@Required @DefaultValueCalculator(CurrentDateCalculator.class) 
	private Date dateCommande;
	
	@DescriptionsList(descriptionProperties="nom")
	@ManyToOne()
	@Required
	private Salarie prisePar;
	
	private Date datePreparation;
	
	@DescriptionsList(descriptionProperties="nom")
	@ManyToOne()
	private Salarie preparePar;
	
	private Date dateLivraison;
	
	@DescriptionsList(descriptionProperties="nom")
	@ManyToOne()
	private Salarie livrePar;
	
	@Column(length=2) @Required
	@DefaultValueCalculator(value=IntegerCalculator.class, properties=@PropertyValue(name="value", value="18"))
	private int tva;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@DescriptionsList(descriptionProperties="nom,prenom")
	private Client client;
	
	@OneToMany(mappedBy="commande", cascade=CascadeType.REMOVE)
	@ListProperties("produit.numero, produit.description, produit.prixUnitaire, quantite, amount[commande.sum, commande.vat, commande.total]")
	private Collection<CommandeDetail> details;
	
	@Stereotype("TEXT_AREA")
	private String remarque;
	
	public BigDecimal getQuantite() {
		BigDecimal sum = BigDecimal.ZERO;
		for (CommandeDetail detail: details) {
			sum = sum.add(detail.getQuantite());
		}
		return sum;
	}
	
	public BigDecimal getSum() {
		BigDecimal sum = BigDecimal.ZERO;
		for (CommandeDetail detail: details) {
			sum = sum.add(detail.getAmount());
		}
		return sum;
	}
	
	public BigDecimal getVat() {
		return getSum().multiply(new BigDecimal(getTva()).divide(new BigDecimal(100))).setScale(2, RoundingMode.UP);
	}
	
	public BigDecimal getTotal() {
		return getSum().add(getVat()).setScale(2, RoundingMode.UP);
	}
	

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int year) {
		this.annee = year;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer number) {
		this.numero = number;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date date) {
		this.dateCommande = date;
	}

	public int getTva() {
		return tva;
	}

	public void setTva(int vatPercentage) {
		this.tva = vatPercentage;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Collection<CommandeDetail> getDetails() {
		return details;
	}

	public void setDetails(Collection<CommandeDetail> details) {
		this.details = details;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarks) {
		this.remarque = remarks;
	}

	public Date getDatePreparation() {
		return datePreparation;
	}

	public void setDatePreparation(Date datePreparation) {
		this.datePreparation = datePreparation;
	}
	public Salarie getPrisePar() {
		return prisePar;
	}

	public void setPrisePar(Salarie prisePar) {
		this.prisePar = prisePar;
	}

	public Salarie getPreparePar() {
		return preparePar;
	}

	public void setPreparePar(Salarie preparePar) {
		this.preparePar = preparePar;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Salarie getLivrePar() {
		return livrePar;
	}

	public void setLivrePar(Salarie livrePar) {
		this.livrePar = livrePar;
	}

}
