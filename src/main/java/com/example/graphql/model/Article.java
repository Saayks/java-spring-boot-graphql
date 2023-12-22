package com.example.graphql.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity
@Table(name="article")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idarticle;

	private String nom;

	private double prix;

	private Integer stock;

	private Integer stockprev;

	//bi-directional many-to-one association to Articlemap
	@OneToMany(mappedBy="article")
	private List<ArticleMap> articlemaps;

	//bi-directional many-to-one association to Production
	@OneToMany(mappedBy="article")
	private List<Production> productions;

	public Article() {
	}

	public Integer getIdarticle() {
		return this.idarticle;
	}

	public void setIdarticle(Integer idarticle) {
		this.idarticle = idarticle;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getStockprev() {
		return this.stockprev;
	}

	public void setStockprev(Integer stockprev) {
		this.stockprev = stockprev;
	}

	public List<ArticleMap> getArticlemaps() {
		return this.articlemaps;
	}

	public void setArticlemaps(List<ArticleMap> articlemaps) {
		this.articlemaps = articlemaps;
	}

	public ArticleMap addArticlemap(ArticleMap articlemap) {
		getArticlemaps().add(articlemap);
		articlemap.setArticle(this);

		return articlemap;
	}

	public ArticleMap removeArticlemap(ArticleMap articlemap) {
		getArticlemaps().remove(articlemap);
		articlemap.setArticle(null);

		return articlemap;
	}

	public List<Production> getProductions() {
		return this.productions;
	}

	public void setProductions(List<Production> productions) {
		this.productions = productions;
	}

	public Production addProduction(Production production) {
		getProductions().add(production);
		production.setArticle(this);

		return production;
	}

	public Production removeProduction(Production production) {
		getProductions().remove(production);
		production.setArticle(null);

		return production;
	}

}