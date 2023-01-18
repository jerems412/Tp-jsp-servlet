package com.securiteweb1.securiteweb1.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "comptes")
public class CompteDto {
	@Id
    @GeneratedValue
	private int id;
    private String username;
    private String password;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "compte_droit", joinColumns = @JoinColumn(name = "compte_id"), inverseJoinColumns = @JoinColumn(name = "droit_id"))
    private Set<DroitDto> droits;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}