package com.example.graphql;

import com.example.graphql.model.*;
import com.example.graphql.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class GraphQLService {

	@Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private BoutiqueRepository boutiqueRepository;

    @Autowired
    private ProductionRepository productionRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapRepository articleMapRepository;
    
    @Autowired
    private CommandeArticleMapRepository commandeArticleMapRepository;
    
    private List<Utilisateur> utilisateurs = new ArrayList<>();
    private List<Article> articles = new ArrayList<>();
    private List<Commande> commandes = new ArrayList<>();
    private List<Production> productions = new ArrayList<>();
    private List<Boutique> boutiques = new ArrayList<>();
    private List<ArticleMap> articlemaps = new ArrayList<>();
    private List<CommandeArticleMap> commandearticlesmaps = new ArrayList<>();
    private AtomicInteger utilisateurIdCounter = new AtomicInteger(1);
    private AtomicInteger articleIdCounter = new AtomicInteger(1);
    private AtomicInteger commandeIdCounter = new AtomicInteger(1);
    private AtomicInteger productionIdCounter = new AtomicInteger(1);
    private AtomicInteger boutiqueIdCounter = new AtomicInteger(1);
    private AtomicInteger stockBoutiqueIdCounter = new AtomicInteger(1);

    
    public GraphQLService() {
    	/* Utilisateur user1 = new Utilisateur(utilisateurIdCounter.getAndIncrement(), "Menez", "Pierre", "Responsable Boutique", "pierre.menez@gmail.com");
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
        
        StockBoutique plancheBoutique1 = new StockBoutique(stockBoutiqueIdCounter.getAndIncrement(), boutique1.getIdBoutique(), article1.getIdArticle(), 4);
        StockBoutique waxBoutique1 = new StockBoutique(stockBoutiqueIdCounter.getAndIncrement(), boutique1.getIdBoutique(), article2.getIdArticle(), 10);
        StockBoutique combiBoutique1 = new StockBoutique(stockBoutiqueIdCounter.getAndIncrement(), boutique1.getIdBoutique(), article3.getIdArticle(), 0);
        stockBoutique1.add(plancheBoutique1);
        stockBoutique1.add(waxBoutique1);
        stockBoutique1.add(combiBoutique1);
        
        List<StockBoutique> stockBoutique2 = new ArrayList<StockBoutique>();
        Boutique boutique2 = new Boutique(boutiqueIdCounter.getAndIncrement(), "13 rue du Forail, 64000 Pau", user3.getIdUtilisateur(), stockBoutique2);
        
        StockBoutique plancheBoutique2 = new StockBoutique(stockBoutiqueIdCounter.getAndIncrement(), boutique2.getIdBoutique(), article1.getIdArticle(), 2);
        StockBoutique waxBoutique2 = new StockBoutique(stockBoutiqueIdCounter.getAndIncrement(), boutique2.getIdBoutique(), article2.getIdArticle(), 5);
        StockBoutique combiBoutique2 = new StockBoutique(stockBoutiqueIdCounter.getAndIncrement(), boutique2.getIdBoutique(), article3.getIdArticle(), 10);
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
        productions.add(productionWax); */
    	
    	//Retrieve all data
    	this.updateDatabase();
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
    
    
    
    public List<Boutique> getAllBoutiques(){
    	return boutiques;
    }
    

    public Optional<Utilisateur> getUserById(Integer id) {
        return utilisateurs.stream().filter(utilisateur -> utilisateur.getIdutilisateur() == id).findFirst();
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
            utilisateurRepository.save(newUtilisateur);
            return newUtilisateur;
        } else {
            // Email already taken
            return null;
        }
    }

    public Utilisateur updateUser(Integer utilisateurId, String nom, String prenom, String email) {
        Optional<Utilisateur> userToUpdate = utilisateurs.stream()
                .filter(u -> u.getIdutilisateur() == utilisateurId)
                .findFirst();
    
        if (userToUpdate.isPresent()) {
            Utilisateur updatedUser = userToUpdate.get();
            if(nom != updatedUser.getNom()) { updatedUser.setNom(nom); }
            if(prenom != updatedUser.getPrenom()) {updatedUser.setPrenom(prenom); }
            if(email != updatedUser.getEmail()) {updatedUser.setEmail(email); }
            utilisateurRepository.save(updatedUser);
            return updatedUser;
        } else {
            // Handle book not found scenario
            return null;
        }
    }

    public Boolean deleteUser(Integer id) {
        Optional<Utilisateur> userToDelete = utilisateurs.stream()
                .filter(u -> u.getIdutilisateur() == id)
                .findFirst();
    
        if (userToDelete.isPresent()) {
            utilisateurs.remove(userToDelete.get());
            utilisateurRepository.delete(userToDelete.get());
            return true;
        } else {
            // Handle book not found scenario
            return false;
        }
    }
    
    public Optional<Commande> createCommande(Integer userId, List<ArticleMap> articles, float coutTot, String type, int idBoutique) {
    	// Create a new order that is going to be instanced
//    	Commande newOrder = new Commande(commandeIdCounter.getAndIncrement(), this.getUserById(userId), articles, coutTot, type, "En Préparation");
//    	commandeRepository.save(newOrder);
//    	for(ArticleMap articleAChoisir : articles) {
//    		var article = articleAChoisir.getArticle();
//    		//Mise à jour du stock prévisionnel
//    		if(article != null) {
//    			article.setStockprev(article.getStockprev() - articleAChoisir.getQuantite());
//    			articleRepository.save(article);
//    		}
//    	}
    	Optional<Commande> newOrder = commandes.stream()
            .filter(commande -> commande.getIdcommande() == 1)
            .findFirst();
    	return newOrder;
    }
    
    public boolean deleteCommande(Integer commandeId) {
        Optional<Commande> commandeToDelete = commandes.stream()
                .filter(commande -> commande.getIdcommande() == commandeId)
                .findFirst();

        if (commandeToDelete.isPresent()) {
            commandes.remove(commandeToDelete.get());
            commandeRepository.delete(commandeToDelete.get());

            return true;
        } else {
            // La commande n'a pas été trouvée
            return false;
        }
    }

    public Commande updateCommande(Integer commandeId, String newStatus) {
        Optional<Commande> commandeToUpdate = commandes.stream()
                .filter(commande -> commande.getIdcommande() == commandeId)
                .findFirst();

        if (commandeToUpdate.isPresent()) {
            Commande updatedCommande = commandeToUpdate.get();
            updatedCommande.setStatus(newStatus);
            commandeRepository.save(updatedCommande);
            return updatedCommande;
        } else {
            // La commande n'a pas été trouvée
            return null;
        }
    }
    
    public Article getArticle(Integer integer) {
        return articles.stream()
                .filter(article -> article.getIdarticle() == integer)
                .findFirst()
                .orElse(null);
    }
   
    
    public List<Commande> getAllCommandesById(Integer userId) {
    	Utilisateur user = this.getUserById(userId).orElse(null);
    	if(user != null) {
    		return commandes.stream()
                .filter(commande -> commande.getUtilisateur() == user)
                .collect(Collectors.toList());
    	}
		else {
			return null;
		}
    }
    
    public boolean updateStock(Integer articleId, int newStock) {
        Optional<Article> articleToUpdate = articles.stream()
                .filter(article -> article.getIdarticle() == articleId)
                .findFirst();

        if (articleToUpdate.isPresent()) {
            Article updatedArticle = articleToUpdate.get();
            updatedArticle.setStock(newStock);
            articleRepository.save(updatedArticle);
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


    public Article updateStockPrev(Integer articleId, int newStockPrev) {
        Optional<Article> articleToUpdate = articles.stream()
                .filter(article -> article.getIdarticle() == articleId)
                .findFirst();

        if (articleToUpdate.isPresent()) {
            Article updatedArticle = articleToUpdate.get();
            updatedArticle.setStockprev(newStockPrev);
            articleRepository.save(updatedArticle);
            return updatedArticle;
        } else {
            // L'article n'a pas été trouvé
            return null;
        }
    }


	public Optional<Article> getArticleById(Integer articleId) {
        return articles.stream().filter(article -> article.getIdarticle() == articleId).findFirst();
	}
    
    public void updateDatabase() {
    	//Only to update the database
    	utilisateurs = this.utilisateurRepository.findAll();
    	articles = this.articleRepository.findAll();
    	commandes = this.commandeRepository.findAll();
    	productions = this.productionRepository.findAll();
    	boutiques = this.boutiqueRepository.findAll();
    }
}

