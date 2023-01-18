package com.securiteweb1.securiteweb1.dao;

import java.util.List;

import com.securiteweb1.securiteweb1.entities.Droit;

public interface DroitDao {
	public Droit findById(int id);
    public List<Droit> findAll();
    public void save(Droit droit);
    public void deleteById(int id);

}
