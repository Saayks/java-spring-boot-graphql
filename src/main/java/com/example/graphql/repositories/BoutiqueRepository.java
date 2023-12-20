package com.example.graphql.repositories;

import com.example.graphql.entities.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, Integer> {
    // Custom query methods can be added here
}
