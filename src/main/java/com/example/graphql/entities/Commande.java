package com.example.graphql.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Commande {
	@Id
	private long idCommande;
	private long idUtilisateur;
	private List<ArticleMap> articles;
	private float coutTotal;
	private String type;
	private int idBoutique;
	private String status;
	
	public Commande(long idCommande, long idUtilisateur, List<ArticleMap> articles, float coutTotal, String type, int idBoutique,
			String status) {
		this.idCommande = idCommande;
		this.idUtilisateur = idUtilisateur;
		this.articles = articles;
		this.coutTotal = coutTotal;
		this.type = type;
		this.idBoutique = idBoutique;
		this.status = status;
	}
	
	public long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}
	
	public long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public List<ArticleMap> getArticles() {
		return articles;
	}
	public void setArticles(List<ArticleMap> articles) {
		this.articles = articles;
	}
	
	public float getCoutTotal() {
		return coutTotal;
	}
	public void setCoutTotal(float coutTotal) {
		this.coutTotal = coutTotal;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public int getIdBoutique() {
		return idBoutique;
	}
	public void setIdBoutique(int idBoutique) {
		this.idBoutique = idBoutique;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
