package com.example.graphql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Article {
	@Id
	private long idArticle;
	private String nom;
	private float prix;
	private int stock;
	private int stockPrev;
	
	public Article(long idArticle, String nom, float prix, int stock, int stockPrev) {
		this.idArticle = idArticle;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.stockPrev = stockPrev;
	}

	public long getIdArticle() {
		return idArticle;
	}
	
	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public float getPrix() {
		return prix;
	}
	
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getStockPrev() {
		return stockPrev;
	}
	
	public void setStockPrev(int stockPrev) {
		this.stockPrev = stockPrev;
	}
	
	
}
