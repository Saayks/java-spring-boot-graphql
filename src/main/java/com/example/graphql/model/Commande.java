package com.example.graphql.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@Table(name="commande")
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcommande;

	private double couttotal;

	private String status;

	private String type;

	//bi-directional many-to-many association to Articlemap
	@ManyToMany
	@JoinTable(
		name="commande_articlemap"
		, joinColumns={
			@JoinColumn(name="idcommande")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idarticlemap")
			}
		)
	private List<ArticleMap> articlemaps;

	//bi-directional many-to-one association to Boutique
	@ManyToOne
	@JoinColumn(name="idboutique")
	private Boutique boutique;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="idutilisateur")
	private Utilisateur utilisateur;

	public Commande() {
	}

	public Integer getIdcommande() {
		return this.idcommande;
	}

	public void setIdcommande(Integer idcommande) {
		this.idcommande = idcommande;
	}

	public double getCouttotal() {
		return this.couttotal;
	}

	public void setCouttotal(double couttotal) {
		this.couttotal = couttotal;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ArticleMap> getArticlemaps() {
		return this.articlemaps;
	}

	public void setArticlemaps(List<ArticleMap> articlemaps) {
		this.articlemaps = articlemaps;
	}

	public Boutique getBoutique() {
		return this.boutique;
	}

	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}