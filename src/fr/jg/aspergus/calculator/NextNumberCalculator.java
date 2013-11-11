package fr.jg.aspergus.calculator;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import fr.jg.aspergus.model2.*;

public class NextNumberCalculator implements ICalculator {

	private String table;
	public String getTable() {
		return table;
	}


	public void setTable(String table) {
		this.table = table;
	}

	
	public Object calculate() throws Exception {
		javax.persistence.Query q = XPersistence.getManager().createQuery("select max(t.numero) from "+getTable()+" t ");
		
		Integer count = (Integer) q.getSingleResult();
		return count==null?1:count+1;
	}

}
