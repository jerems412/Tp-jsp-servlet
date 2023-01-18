package com.securiteweb1.securiteweb1.dao;

import java.util.List;

import com.securiteweb1.securiteweb1.entities.Compte;

public interface CompteDao {
	Compte findById(int id);
    List<Compte> findAll();
    void save(Compte compte);
    void deleteById(int id);
    Compte logon(String username, String password);

}
