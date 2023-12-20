package com.example.graphql.repositories;

import com.example.graphql.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    // Custom query methods can be added here
}
