package com.securiteweb1.securiteweb1.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "droits")
public class Droit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	@Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "droits")
    private Set<Compte> comptes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
