package fr.jg.aspergus.model2;

import java.math.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.model.*;

@Entity
@Views({
	@View(members=" Entête [annee, numero, date, tva];" +
		"client;" +
		"details;" +
		"remarque"
	),
	@View(name="WithSections", members=
		"annee, numero, date, tva;" +
		"client { client }" +
		"details { details }" +
		"remarque { remarque } "			
	)	
})
@Tab(properties="annee, numero, date, client.name, remarque")
public class Commande extends Identifiable {
	
	@DefaultValueCalculator(CurrentYearCalculator.class)
	@Column(length=4) @Required
	private int annee;
	
	
	
	@Column(length=6) @Required	
	private Integer numero;
	
	@Required @DefaultValueCalculator(CurrentDateCalculator.class) 
	private Date date;
	
	@Column(length=2) @Required
	@DefaultValueCalculator(value=IntegerCalculator.class, properties=@PropertyValue(name="value", value="18"))
	private int tva;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int number) {
		this.numero = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

}
