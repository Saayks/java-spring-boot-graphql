package com.example.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.model.Boutique;


@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, Integer> {
    // Custom query methods can be added here
}
