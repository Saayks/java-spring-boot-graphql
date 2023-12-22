package com.example.graphql.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

/**
 * The persistent class for the production database table.
 * 
 */
@Entity
@Table(name="production")
@NamedQuery(name="Production.findAll", query="SELECT p FROM Production p")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idproduction;

	private Integer productionj;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;

	public Production() {
	}

	public Integer getIdproduction() {
		return this.idproduction;
	}

	public void setIdproduction(Integer idproduction) {
		this.idproduction = idproduction;
	}

	public Integer getProductionj() {
		return this.productionj;
	}

	public void setProductionj(Integer productionj) {
		this.productionj = productionj;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}