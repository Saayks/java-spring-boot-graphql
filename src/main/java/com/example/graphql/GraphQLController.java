package com.example.graphql;

import com.example.graphql.entities.Article;
import com.example.graphql.entities.Book;
import com.example.graphql.entities.Boutique;
import com.example.graphql.entities.Commande;
import com.example.graphql.entities.Production;
import com.example.graphql.entities.StockBoutique;
import com.example.graphql.entities.Utilisateur;

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

    @QueryMapping
    public List<Utilisateur> getAllUsers() {
        return graphQLService.getAllUsers();
    }

    @QueryMapping
    public Utilisateur getUserById(@Argument("id") Long id) {
        return graphQLService.getUserById(id).orElse(null);
    }
    
    @QueryMapping
    public Utilisateur getUserByEmail(@Argument("email") String email) {
        return graphQLService.getUserById(email).orElse(null);
    }
    
    @QueryMapping
    public List<Commande> getAllCommandes() {
    	return graphQLService.getAllCommandes();
    }
    
    @QueryMapping
    public Commande getAllCommandesById(@Argument("idCommande") int idCommande) {
    	return graphQLService.getAllCommandesById(idCommande);
    }
    
    @QueryMapping
    public List<Boutique> getAllBoutiques() {
    	return graphQLService.getAllBoutiques();
    }
    
    @QueryMapping
    public List<StockBoutique> getAllStockByBoutique(@Argument('idBoutique') int idBoutique) {
    	return graphQLService.getAllStockByBoutique();
    }
    
    @QueryMapping
    public List<Production> getAllProduction() {
    	return graphQLService.getAllProduction();
    }
    
    
    @MutationMapping
    public Utilisateur createUser(@Argument("nom") String nom, @Argument("prenom") String prenom, @Argument("email") String email) {
        return graphQLService.createUser(nom, prenom, email);
    }

   
    @MutationMapping
    public Article updateStock(@Argument("stock") int stock) {
    	return graphQLService.updateStock(stock);
    }
    
    /* Fait pour calculer avec le stock de sécurité si pré-commande */
    @MutationMapping
    public Article updateStockPrev(@Argument("stock") int stock) {
    	return graphQLService.updateStockPrev(stock);
    }
    
}
