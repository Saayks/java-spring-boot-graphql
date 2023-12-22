package com.example.graphql.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

/**
 * The persistent class for the commande_articlemap database table.
 * 
 */
@Entity
@Table(name="commande_articlemap")
@NamedQuery(name="CommandeArticleMap.findAll", query="SELECT c FROM CommandeArticleMap c")
public class CommandeArticleMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcommandearticlemap;
	
	private Integer idcommande;

	//bi-directional many-to-one association to Articlemap
	@ManyToOne
	@JoinColumn(name="idarticlemap")
	private ArticleMap articlemap;

	public CommandeArticleMap() {
	}

	
	public Integer getIdcommandearticlemap() {
		return this.idcommandearticlemap;
	}


	public void setIdcommandearticlemap(Integer idcommandearticlemap) {
		this.idcommandearticlemap = idcommandearticlemap;
	}


	public Integer getIdcommande() {
		return this.idcommande;
	}

	public void setIdcommande(Integer idcommande) {
		this.idcommande = idcommande;
	}

	public ArticleMap getArticlemap() {
		return this.articlemap;
	}

	public void setArticlemap(ArticleMap articlemap) {
		this.articlemap = articlemap;
	}

}