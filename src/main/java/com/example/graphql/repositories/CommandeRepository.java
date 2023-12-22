package com.example.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.model.Commande;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
    // Custom query methods can be added here
}
