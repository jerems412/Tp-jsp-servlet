package com.securiteweb1.securiteweb1.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.securiteweb1.securiteweb1.entities.Droit;

public class DroitDaoImpl implements DroitDao{
	private Session session;
	private SessionFactory sessionFactory;
	
	public DroitDaoImpl() {
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
    	this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	this.session = this.sessionFactory.openSession();
  }

	@Override
	public Droit findById(int id) {
		return session.get(Droit.class, id);
	}

	@Override
	public List<Droit> findAll() {
		return session.createQuery("select * from Droit droits").getResultList();
	}

	@Override
	public void save(Droit droit) {
		try {
	        this.session.beginTransaction();
	        this.session.save(droit);
	        this.session.getTransaction().commit();
	    } catch (HibernateException e) {
	        this.session.getTransaction().rollback();
	        throw e;
	    } finally {
	        //this.session.close();
	    } 
		
	}

	@Override
	public void deleteById(int id) {
		try {
	        this.session.beginTransaction();
	        this.session.delete(this.findById(id));
	        this.session.getTransaction().commit();
	    } catch (HibernateException e) {
	        this.session.getTransaction().rollback();
	        throw e;
	    } finally {
	        //this.session.close();
	    } 
		
	}

}
