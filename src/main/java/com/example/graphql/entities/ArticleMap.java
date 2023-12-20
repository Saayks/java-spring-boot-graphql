package com.example.graphql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ArticleMap {
	@Id
	private long idArticleMap;
	private long idArticle;
	private int quantite;
	
	public ArticleMap(long idArticleMap, long idArticle, int quantite) {
		this.idArticleMap = idArticleMap;
		this.idArticle = idArticle;
		this.quantite = quantite;
	}
	
	public long getIdArticleMap() {
		return idArticleMap;
	}
	public void setIdArticleMap(long idArticleMap) {
		this.idArticleMap = idArticleMap;
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
