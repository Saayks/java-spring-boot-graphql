package com.example.graphql.entities;

public class StockBoutique {

	private long idBoutique;
	private long idArticle;
	private int quantite;
	
	public StockBoutique(long idBoutique, long idArticle, int quantite) {
		this.idBoutique = idBoutique;
		this.idArticle = idArticle;
		this.quantite = quantite;
	}
	
	public long getIdBoutique() {
		return idBoutique;
	}

	public void setIdBoutique(long idBoutique) {
		this.idBoutique = idBoutique;
	}

	public long getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
}
