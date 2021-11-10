package com.example.td1.td1.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long numE;
	
	private String nomE;
	
	private int niveau;

	private Date dateEntree;

	public Etudiant() {
	};

	public Etudiant(String nomE, int niveau, Specialite i, Departement j,double moyenne) {
		this.nomE = nomE;
		this.niveau = niveau;
		this.idspecialite = i;
		this.iddepartement = j;
		this.moyenne = moyenne;
	}

    @ManyToOne
	@JoinColumn(name="idSpecialite")
	private Specialite idspecialite;
	
	@ManyToOne
	@JoinColumn(name="idDept")
	private Departement iddepartement;
	
	private double moyenne;

	public Long getNumE() {
		return numE;
	}

	public void setNumE(Long numE) {
		this.numE = numE;
	}

	public String getNomE() {
		return nomE;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
	}
	
	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	
	public Specialite getIdspecialite() {
		return idspecialite;
	}
	
	public void setIdspecialite(Specialite idspecialite) {
		this.idspecialite = idspecialite;
	}
	
	public Departement getIddepartement() {
		return iddepartement;
	}
	
	public void setIddepartement(Departement iddepartement) {
		this.iddepartement = iddepartement;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	@Override
	public String toString() {
		return "Etudiants [IdE=" + numE + ", NomE=" + nomE + ", Niveau=" + niveau + ", DateE=" + dateEntree + ", st=" + idspecialite
				+ ", dt=" + iddepartement + ", moyenne=" + moyenne + "]";
	}
}
