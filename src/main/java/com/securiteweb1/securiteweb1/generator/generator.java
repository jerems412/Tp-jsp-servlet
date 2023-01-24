package com.securiteweb1.securiteweb1.generator;

import com.securiteweb1.securiteweb1.dao.CompteDao;
import com.securiteweb1.securiteweb1.dao.CompteDaoImpl;
import com.securiteweb1.securiteweb1.entities.Compte;

public class generator {
	public static void main(String[] args) {
		CompteDao c = new CompteDaoImpl();
		Compte compte = new Compte();
		compte.setUsername("test");
		compte.setPassword("test");
		c.save(compte);
		System.out.print("valider");

    }

}
