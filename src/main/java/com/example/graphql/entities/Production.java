package com.example.graphql.entities;

public class Production {

	private long idProduction;
	private long idArticle;
	private int productionJ;
	
	public Production(long idProduction, long idArticle, int productionJ) {
		this.idProduction = idProduction;
		this.idArticle = idArticle;
		this.productionJ = productionJ;
	}

	public long getIdProduction() {
		return idProduction;
	}
	
	public void setIdProduction(long idProduction) {
		this.idProduction = idProduction;
	}
	
	public long getIdArticle() {
		return idArticle;
	}
	
	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}
	
	public int getProductionJ() {
		return productionJ;
	}
	
	public void setProductionJ(int productionJ) {
		this.productionJ = productionJ;
	}
	
	
}
