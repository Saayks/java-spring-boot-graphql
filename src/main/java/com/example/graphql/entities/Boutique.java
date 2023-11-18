package com.example.graphql.entities;

import java.util.List;

public class Boutique {

	private long idBoutique;
	private String adresse;
	private long responsableBoutique;
	private List<StockBoutique> articles;
	
	public Boutique(long idBoutique, String adresse, long responsableBoutique, List<StockBoutique> articles) {
		this.idBoutique = idBoutique;
		this.adresse = adresse;
		this.responsableBoutique = responsableBoutique;
		this.articles = articles;
	}

	public long getIdBoutique() {
		return idBoutique;
	}
	
	public void setIdBoutique(long idBoutique) {
		this.idBoutique = idBoutique;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public long getResponsableBoutique() {
		return responsableBoutique;
	}
	
	public void setResponsableBoutique(long responsableBoutique) {
		this.responsableBoutique = responsableBoutique;
	}
	
	public List<StockBoutique> getArticles() {
		return articles;
	}
	
	public void setArticles(List<StockBoutique> articles) {
		this.articles = articles;
	}
	
	
}
