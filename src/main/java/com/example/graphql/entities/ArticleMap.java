package com.example.graphql.entities;

public class ArticleMap {

	private long idArticle;
	private int quantite;
	
	public ArticleMap(long idArticle, int quantite) {
		this.idArticle = idArticle;
		this.quantite = quantite;
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
