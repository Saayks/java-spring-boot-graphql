package com.example.graphql;

import com.example.graphql.entities.*;
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
    public Utilisateur getUserById(@Argument("id") Long id) {
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
    public List<Commande> getAllCommandesById(@Argument("idUtilisateur") long idUtilisateur) {
    	return graphQLService.getAllCommandesById(idUtilisateur);
    }
    
    /* Fait pour mettre à jour le statut d'une commande */
    @MutationMapping
    public Commande updateCommande(@Argument("commandeId") long commandeId, @Argument("newStatus") String newStatus) {
        return graphQLService.updateCommande(commandeId, newStatus);
    }
    
    /* Fait pour supprimer une commande */
    @MutationMapping
    public boolean deleteCommande(@Argument("commandeId") long commandeId) {
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
    public List<Article> getAllArticle() {
    	return graphQLService.getAllArticles();
    }
    
    @QueryMapping
    public Article getArticleById(@Argument("articleId") long articleId) {
    	return graphQLService.getArticleById(articleId).orElse(null);
    }
    
    /* Fait pour mettre à jour le stock d'un article */
    @MutationMapping
    public boolean updateStock(@Argument("idArticle") long idArticle, @Argument("stock") int stock) {
        return graphQLService.updateStock(idArticle, stock);
    }
    
    /* Fait pour calculer avec le stock de sécurité si pré-commande */
    @MutationMapping
    public Article updateStockPrev(@Argument("idArticle") long idArticle, @Argument("stock") int stock) {
    	return graphQLService.updateStockPrev(idArticle, stock);
    }

    /* Fait pour mettre à jour le stock d'un article par son ID */
    @MutationMapping
    public Article updateStockById(@Argument("article") Article article, @Argument("newStock") int newStock) {
        return graphQLService.updateStock(article, newStock);
    }
    
    /* Fait pour mettre à jour le stock prévisionnel d'un article par son ID */
    @MutationMapping
    public Article updateStockPrevById(@Argument("articleId") long articleId, @Argument("newStockPrev") int newStockPrev) {
        return graphQLService.updateStockPrev(articleId, newStockPrev);
    }

    // --------------------------- StockBoutique Section (unused, I think)-----------------------------------

    
    /* Récupération du stock de la boutique */
    @MutationMapping
    public StockBoutique getStockBoutiqueById(@Argument("idBoutique") long idBoutique) {
    	return graphQLService.getStockBoutique(idBoutique);
    }
    
    
}
