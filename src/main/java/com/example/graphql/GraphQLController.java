package com.example.graphql;

import com.example.graphql.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {

    @Autowired
    private GraphQLService graphQLService;

// --------------------------- User Section -----------------------------------
    @QueryMapping
    public List<Utilisateur> getAllUsers() {
        return graphQLService.getAllUtilisateurs();
    }

    @QueryMapping
    public Utilisateur getUserById(@Argument("id") Integer id) {
        return graphQLService.getUserById(id).orElse(null);
    }
    
    @QueryMapping
    public Utilisateur getUserByEmail(@Argument("email") String email) {
        return graphQLService.getUserByEmail(email).orElse(null);
    }
    
    @MutationMapping
    public Utilisateur createUser(@Argument("nom") String nom, @Argument("prenom") String prenom, @Argument("email") String email) {
        return graphQLService.createUser(nom, prenom, email);
    }
    
 // --------------------------- Commande Section -----------------------------------
    @QueryMapping
    public List<Commande> getAllCommandes() {
    	return graphQLService.getAllCommandes();
    }
    
    @QueryMapping
    public List<Commande> getAllCommandesById(@Argument("idUtilisateur") Integer idUtilisateur) {
    	return graphQLService.getAllCommandesById(idUtilisateur);
    }
    
    /* Fait pour mettre à jour le statut d'une commande */
    @MutationMapping
    public Commande updateCommande(@Argument("commandeId") Integer commandeId, @Argument("newStatus") String newStatus) {
        return graphQLService.updateCommande(commandeId, newStatus);
    }
    
    /* Fait pour supprimer une commande */
    @MutationMapping
    public boolean deleteCommande(@Argument("commandeId") Integer commandeId) {
        return graphQLService.deleteCommande(commandeId);
    }

 // --------------------------- Boutique Section -----------------------------------
    @QueryMapping
    public List<Boutique> getAllBoutiques() {
    	return graphQLService.getAllBoutiques();
    }
    
    
 // --------------------------- Production Section -----------------------------------

    @QueryMapping
    public List<Production> getAllProduction() {
    	return graphQLService.getAllProductions();
    }
    
    
 // --------------------------- Article Section -----------------------------------
    
    @QueryMapping
    public List<Article> getAllArticles() {
    	return graphQLService.getAllArticles();
    }
    
    @QueryMapping
    public Article getArticleById(@Argument("articleId") Integer articleId) {
    	return graphQLService.getArticleById(articleId).orElse(null);
    }
    
    /* Fait pour mettre à jour le stock d'un article */
    @MutationMapping
    public boolean updateStock(@Argument("idArticle") Integer idArticle, @Argument("stock") int stock) {
        return graphQLService.updateStock(idArticle, stock);
    }
    
    /* Fait pour calculer avec le stock de sécurité si pré-commande */
    @MutationMapping
    public Article updateStockPrev(@Argument("idArticle") Integer idArticle, @Argument("stock") int stock) {
    	return graphQLService.updateStockPrev(idArticle, stock);
    }

    /* Fait pour mettre à jour le stock d'un article par son ID */
    @MutationMapping
    public Article updateStockById(@Argument("article") Article article, @Argument("newStock") int newStock) {
        return graphQLService.updateStock(article, newStock);
    }
    
    /* Fait pour mettre à jour le stock prévisionnel d'un article par son ID */
    @MutationMapping
    public Article updateStockPrevById(@Argument("articleId") Integer articleId, @Argument("newStockPrev") int newStockPrev) {
        return graphQLService.updateStockPrev(articleId, newStockPrev);
    }

    // --------------------------- StockBoutique Section (unused, I think)-----------------------------------
    
}
