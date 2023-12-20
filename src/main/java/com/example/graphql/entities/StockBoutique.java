package com.example.graphql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StockBoutique {
	@Id
	private long idStockBoutique;
	private long idBoutique;
	private long idArticle;
	private int quantite;
	
	public StockBoutique(long idStockBoutique, long idBoutique, long idArticle, int quantite) {
		this.idStockBoutique = idStockBoutique;
		this.idBoutique = idBoutique;
		this.idArticle = idArticle;
		this.quantite = quantite;
	}
	
	public long getIdStockBoutique() {
		return idStockBoutique;
	}

	public void setIdStockBoutique(long idStockBoutique) {
		this.idStockBoutique = idStockBoutique;
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
