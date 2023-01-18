package com.securiteweb1.securiteweb1.dto;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "droits")
public class DroitDto {
	@Id
    @GeneratedValue
	private int id;
    private String name;
    @ManyToMany(mappedBy = "droits")
    private Set<CompteDto> comptes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
