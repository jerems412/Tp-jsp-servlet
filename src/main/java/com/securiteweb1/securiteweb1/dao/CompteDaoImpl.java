package com.securiteweb1.securiteweb1.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.securiteweb1.securiteweb1.entities.Compte;

public class CompteDaoImpl implements CompteDao {
	private Session session;
	private SessionFactory sessionFactory;

    public CompteDaoImpl() {
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
    	this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	this.session = this.sessionFactory.openSession();
    }

	@Override
	public Compte findById(int id) {
		return session.get(Compte.class, id);
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> result = this.session.createQuery("FROM Compte", Compte.class).getResultList();
		return result;
	}

	@Override
	public void save(Compte compte) {
	    try {
	        this.session.beginTransaction();
	        this.session.save(compte);
	        this.session.getTransaction().commit();
	    } catch (Exception e) {
			e.printStackTrace();
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
	
	@Override
	public Compte logon(String username, String password) {
		try {
			Compte compte1 = new Compte();
			System.out.print("je suis la");
			List<Compte> result = this.session.createQuery("from comptes", Compte.class).list();
			System.out.print("je suis encore la");
			for(Compte value : result ) {
				if(username.equals(value.getUsername()) && password.equals(value.getPassword())) {
					compte1.setPassword(value.getPassword());
					compte1.setUsername(value.getUsername());
				}
			}
			return compte1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
