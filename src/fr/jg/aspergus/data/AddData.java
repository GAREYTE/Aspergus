package fr.jg.aspergus.data;

import javax.persistence.*;

import org.hibernate.validator.xml.*;
import org.openxava.jpa.*;

import fr.jg.aspergus.model2.*;

public class AddData {

	
	public static void main(String[] args) {
		Client cli = new Client();
		cli.setNom("LASSU");
		XPersistence.setDefaultSchema("default");
		XPersistence.getManager().persist(cli);

	}
}
