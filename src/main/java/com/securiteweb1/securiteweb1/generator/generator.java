package com.securiteweb1.securiteweb1.generator;

import com.securiteweb1.securiteweb1.dao.CompteDao;
import com.securiteweb1.securiteweb1.dao.CompteDaoImpl;
import com.securiteweb1.securiteweb1.entities.Compte;

public class generator {
	public static void main(String[] args) {
		CompteDao c = new CompteDaoImpl();
		Compte compte = new Compte();
		compte.setPassword("password");
		compte.setUsername("jeremy");
		System.out.print(c.logon(compte.getUsername(),compte.getPassword()).getUsername());;

    }

}
