package com.example.graphql.entities;

public class Utilisateur {

	private long idUtilisateur;
	private String nom;
	private String prenom;
	private String poste;
	private String email;
	
	public Utilisateur(long idUtilisateur, String nom, String prenom, String poste, String email) {
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.poste = poste;
		this.email = email;
	}

	public long getIdUtilisateur() {
		return idUtilisateur;
	}
	
	public void setIdUtilisateur(long idUser) {
		this.idUtilisateur = idUser;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getPoste() {
		return poste;
	}
	
	public void setPoste(String poste) {
		this.poste = poste;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
