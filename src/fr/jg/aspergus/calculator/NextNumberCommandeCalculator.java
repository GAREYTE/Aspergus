package fr.jg.aspergus.calculator;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import fr.jg.aspergus.model2.*;

public class NextNumberCommandeCalculator implements ICalculator {

	private Integer annee;
	public Integer getAnnee() {
		return annee;
	}


	public void setAnnee(Integer year) {
		this.annee = year;
	}

	
	public Object calculate() throws Exception {
		javax.persistence.Query q = XPersistence.getManager().createQuery("select max(c.numero) from Commande c where annee=:annee");
		q.setParameter("annee", annee);
		Integer count = (Integer) q.getSingleResult();
		return count==null?1:count+1;
	}

}
