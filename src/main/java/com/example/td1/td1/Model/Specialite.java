package com.example.td1.td1.Model;

import java.util.Collection;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Specialite {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long idSpecialite;
	
	private String libelleSpecialite;
	

	public Specialite() {
	};

	public Specialite(Long idSpecialite, String libelleSpecialite) {
		this.idSpecialite = idSpecialite;
		this.libelleSpecialite = libelleSpecialite;
	}

	@JsonIgnore
	@OneToMany (mappedBy="idspecialite", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Collection<Etudiant> etudiants;

	public Long getIdSpecialite() {
		return idSpecialite;
	}

	public void setIdSpecialite(Long idSpecialite) {
		this.idSpecialite = idSpecialite;
	}

	public String getLibelleSpecialite() {
		return libelleSpecialite;
	}

	public void setLibelleSpecialite(String libelleSpecialite) {
		this.libelleSpecialite = libelleSpecialite;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Specialite(String libelleSpecialite) {
		super();
		this.libelleSpecialite = libelleSpecialite;
	}

	
	
}
