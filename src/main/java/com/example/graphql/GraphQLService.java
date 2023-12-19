package com.example.graphql;

import com.example.graphql.entities.Article;
import com.example.graphql.entities.ArticleMap;
import com.example.graphql.entities.Boutique;
import com.example.graphql.entities.Commande;
import com.example.graphql.entities.Production;
import com.example.graphql.entities.StockBoutique;
import com.example.graphql.entities.Utilisateur;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class GraphQLService {

    private List<Utilisateur> utilisateurs = new ArrayList<>();
    private List<Article> articles = new ArrayList<>();
    private List<Commande> commandes = new ArrayList<>();
    private List<Production> productions = new ArrayList<>();
    private List<List<StockBoutique>> stocks = new ArrayList<>();
    private List<Boutique> boutiques = new ArrayList<>();
    private AtomicLong utilisateurIdCounter = new AtomicLong(1);
    private AtomicLong articleIdCounter = new AtomicLong(1);
    private AtomicLong commandeIdCounter = new AtomicLong(1);
    private AtomicLong productionIdCounter = new AtomicLong(1);
    private AtomicLong boutiqueIdCounter = new AtomicLong(1);

    public GraphQLService() {
    	Utilisateur user1 = new Utilisateur(utilisateurIdCounter.getAndIncrement(), "Menez", "Pierre", "Responsable Boutique", "pierre.menez@gmail.com");
    	Utilisateur user2 = new Utilisateur(utilisateurIdCounter.getAndIncrement(), "Henry", "Thierry", "Logisiticien", "thierry.henry@hotmail.fr");
    	Utilisateur user3 = new Utilisateur(utilisateurIdCounter.getAndIncrement(), "Bruel", "Patrick", "Responsable Boutique", "patrick.bruel@yahoo.fr");
    	utilisateurs.add(user1);
    	utilisateurs.add(user2);
    	utilisateurs.add(user3);

        Article article1 = new Article(articleIdCounter.getAndIncrement(), "Planche Ergonomique", (float) 500, 15, 15);
        Article article2 = new Article(articleIdCounter.getAndIncrement(), "Wax", (float) 15, 100, 100);
        Article article3 = new Article(articleIdCounter.getAndIncrement(), "Combinaison", (float) 200, 23,23);
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        
        List<StockBoutique> stockBoutique1 = new ArrayList<StockBoutique>();
        Boutique boutique1 = new Boutique(boutiqueIdCounter.getAndIncrement(), "153 avenue Montaury, 64600 Anglet", user1.getIdUtilisateur(), stockBoutique1);
        
        StockBoutique plancheBoutique1 = new StockBoutique(boutique1.getIdBoutique(), article1.getIdArticle(), 4);
        StockBoutique waxBoutique1 = new StockBoutique(boutique1.getIdBoutique(), article2.getIdArticle(), 10);
        StockBoutique combiBoutique1 = new StockBoutique(boutique1.getIdBoutique(), article3.getIdArticle(), 0);
        stockBoutique1.add(plancheBoutique1);
        stockBoutique1.add(waxBoutique1);
        stockBoutique1.add(combiBoutique1);
        
        List<StockBoutique> stockBoutique2 = new ArrayList<StockBoutique>();
        Boutique boutique2 = new Boutique(boutiqueIdCounter.getAndIncrement(), "13 rue du Forail, 64000 Pau", user3.getIdUtilisateur(), stockBoutique2);
        
        StockBoutique plancheBoutique2 = new StockBoutique(boutique2.getIdBoutique(), article1.getIdArticle(), 2);
        StockBoutique waxBoutique2 = new StockBoutique(boutique2.getIdBoutique(), article2.getIdArticle(), 5);
        StockBoutique combiBoutique2 = new StockBoutique(boutique2.getIdBoutique(), article3.getIdArticle(), 10);
        stockBoutique2.add(plancheBoutique2);
        stockBoutique2.add(waxBoutique2);
        stockBoutique2.add(combiBoutique2);
        
        stocks.add(stockBoutique1);
        stocks.add(stockBoutique2);
        
        Production productionPlanche = new Production(productionIdCounter.getAndIncrement(), article1.getIdArticle(), 5);
        Production productionWax = new Production(productionIdCounter.getAndIncrement(), article2.getIdArticle(), 50);
        Production productionCombi = new Production(productionIdCounter.getAndIncrement(), article3.getIdArticle(), 3);
        productions.add(productionPlanche);
        productions.add(productionCombi);
        productions.add(productionWax);
    }

    
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurs;
    }
    
    
    public List<Commande> getAllCommandes(){
    	return commandes;
    }
    
    
    public List<Production> getAllProductions() {
        return productions;
    }
    
    
    public List<Article> getAllArticles(){
    	return articles;
    }
    
    
    public List<List<StockBoutique>> getAllStockBoutiques() {
        return stocks;
    }
    
    public List<Boutique> getAllBoutiques(){
    	return boutiques;
    }
    

    public Optional<Utilisateur> getUserById(Long id) {
        return utilisateurs.stream().filter(utilisateur -> utilisateur.getIdUtilisateur() == id).findFirst();
    }

    
    public Optional<Utilisateur> getUserByEmail(String email) {
        return utilisateurs.stream().filter(utilisateur -> utilisateur.getEmail().equals(email)).findFirst();
    }
    
    
    public Utilisateur createUser(String nom, String prenom, String email) {
    	Utilisateur utilisateur = utilisateurs.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);

        if (utilisateur == null) {
        	//Create new user
            Utilisateur newUtilisateur = new Utilisateur(utilisateurIdCounter.getAndIncrement(), nom, prenom, email, "Client");
            utilisateurs.add(newUtilisateur);
            return newUtilisateur;
        } else {
            // Email already taken
            return null;
        }
    }

    public Utilisateur updateUser(Long utilisateurId, String nom, String prenom, String email) {
        Optional<Utilisateur> userToUpdate = utilisateurs.stream()
                .filter(u -> u.getIdUtilisateur() == utilisateurId)
                .findFirst();
    
        if (userToUpdate.isPresent()) {
            Utilisateur updatedUser = userToUpdate.get();
            if(nom != updatedUser.getNom()) { updatedUser.setNom(nom); }
            if(prenom != updatedUser.getPrenom()) {updatedUser.setPrenom(prenom); }
            if(email != updatedUser.getEmail()) {updatedUser.setEmail(email); }
            return updatedUser;
        } else {
            // Handle book not found scenario
            return null;
        }
    }

    public Boolean deleteUser(Long id) {
        Optional<Utilisateur> userToDelete = utilisateurs.stream()
                .filter(u -> u.getIdUtilisateur() == id)
                .findFirst();
    
        if (userToDelete.isPresent()) {
            utilisateurs.remove(userToDelete.get());
            return true;
        } else {
            // Handle book not found scenario
            return false;
        }
    }
    
    public Commande createCommande(Long userId, List<ArticleMap> articles, float coutTot, String type, int idBoutique) {
    	// Create a new order that is going to be instanced
    	Commande newOrder = new Commande(commandeIdCounter.getAndIncrement(), userId, articles, coutTot, type, idBoutique, "En Préparation");
    	for(ArticleMap articleAChoisir : articles) {
    		var article = this.getArticle(articleAChoisir.getIdArticle());
    		//Mise à jour du stock prévisionnel
    		if(article != null) {
    			article.setStockPrev(article.getStockPrev() - articleAChoisir.getQuantite());
    		}
    	}
    	return newOrder;
    }
    
    public boolean deleteCommande(Long commandeId) {
        Optional<Commande> commandeToDelete = commandes.stream()
                .filter(commande -> commande.getIdCommande() == commandeId)
                .findFirst();

        if (commandeToDelete.isPresent()) {
            commandes.remove(commandeToDelete.get());
            return true;
        } else {
            // La commande n'a pas été trouvée
            return false;
        }
    }

    public Commande updateCommande(Long commandeId, String newStatus) {
        Optional<Commande> commandeToUpdate = commandes.stream()
                .filter(commande -> commande.getIdCommande() == commandeId)
                .findFirst();

        if (commandeToUpdate.isPresent()) {
            Commande updatedCommande = commandeToUpdate.get();
            updatedCommande.setStatus(newStatus);
            return updatedCommande;
        } else {
            // La commande n'a pas été trouvée
            return null;
        }
    }
    
    public Article getArticle(Long articleId) {
        return articles.stream()
                .filter(article -> article.getIdArticle() == articleId)
                .findFirst()
                .orElse(null);
    }
    
    public List<Commande> getAllCommandesById(Long userId) {
        return commandes.stream()
                .filter(commande -> commande.getIdUtilisateur() == userId)
                .collect(Collectors.toList());
    }
    
    public boolean updateStock(Long articleId, int newStock) {
        Optional<Article> articleToUpdate = articles.stream()
                .filter(article -> article.getIdArticle() == articleId)
                .findFirst();

        if (articleToUpdate.isPresent()) {
            Article updatedArticle = articleToUpdate.get();
            updatedArticle.setStock(newStock);
            return true;
        } else {
            // L'article n'a pas été trouvé
            return false;
        }
    }
    
    public Article updateStock(Article articleToUpdate, int newStock) {
		articleToUpdate.setStock(newStock);
        return articleToUpdate;
    }


    public Article updateStockPrev(Long articleId, int newStockPrev) {
        Optional<Article> articleToUpdate = articles.stream()
                .filter(article -> article.getIdArticle() == articleId)
                .findFirst();

        if (articleToUpdate.isPresent()) {
            Article updatedArticle = articleToUpdate.get();
            updatedArticle.setStockPrev(newStockPrev);
            return updatedArticle;
        } else {
            // L'article n'a pas été trouvé
            return null;
        }
    }
    
    public StockBoutique getStockBoutique(long boutiqueId) {
        return stocks.stream()
                .flatMap(List::stream)
                .filter(stockBoutique -> stockBoutique.getIdBoutique() == boutiqueId)
                .findFirst()
                .orElse(null);
    }


	public Optional<Article> getArticleById(long articleId) {
        return articles.stream().filter(article -> article.getIdArticle() == articleId).findFirst();
	}
    
    
}

