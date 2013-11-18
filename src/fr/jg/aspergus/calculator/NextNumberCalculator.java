package fr.jg.aspergus.calculator;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import fr.jg.aspergus.model2.*;

public class NextNumberCalculator implements ICalculator {

	private String table;
	public String getTable() {
		return table;
	}


<<<<<<< Upstream, based on branch 'master' of https://github.com/GAREYTE/Aspergus.git
	public void setTable(String table) {
		this.table = table;
	}

	
	public Object calculate() throws Exception {
		javax.persistence.Query q = XPersistence.getManager().createQuery("select max(t.numero) from "+getTable()+" t ");
		
=======
	public void setTable(String	table) {
		this.table = table;
	}

	
	public Object calculate() throws Exception {
		javax.persistence.Query q = XPersistence.getManager().createQuery("select max(t.numero) from "+table+" t ");
>>>>>>> d3e2dac Calculated number
		Integer count = (Integer) q.getSingleResult();
		return count==null?1:count+1;
	}

}
