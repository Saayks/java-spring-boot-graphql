package com.example.graphql.model;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import java.util.List;


/**
 * The persistent class for the articlemap database table.
 * 
 */
@Entity
@Table(name="articlemap")
@NamedQuery(name="ArticleMap.findAll", query="SELECT a FROM ArticleMap a")
public class ArticleMap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idarticlemap;

	private Integer quantite;

	//bi-directional many-to-one association to Article
	@ManyToOne
	@JoinColumn(name="idarticle")
	private Article article;

	//bi-directional many-to-many association to Commande
	@ManyToMany(mappedBy="articlemaps")
	private List<Commande> commandes;

	//bi-directional many-to-one association to CommandeArticlemap
	@OneToMany(mappedBy="articlemap")
	private List<CommandeArticleMap> commandeArticlemaps;

	public ArticleMap() {
	}

	public Integer getIdarticlemap() {
		return this.idarticlemap;
	}

	public void setIdarticlemap(Integer idarticlemap) {
		this.idarticlemap = idarticlemap;
	}

	public Integer getQuantite() {
		return this.quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Article getArticle() {
		return this.article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<CommandeArticleMap> getCommandeArticlemaps() {
		return this.commandeArticlemaps;
	}

	public void setCommandeArticlemaps(List<CommandeArticleMap> commandeArticlemaps) {
		this.commandeArticlemaps = commandeArticlemaps;
	}

	public CommandeArticleMap addCommandeArticlemap(CommandeArticleMap commandeArticlemap) {
		getCommandeArticlemaps().add(commandeArticlemap);
		commandeArticlemap.setArticlemap(this);

		return commandeArticlemap;
	}

	public CommandeArticleMap removeCommandeArticlemap(CommandeArticleMap commandeArticlemap) {
		getCommandeArticlemaps().remove(commandeArticlemap);
		commandeArticlemap.setArticlemap(null);

		return commandeArticlemap;
	}

}