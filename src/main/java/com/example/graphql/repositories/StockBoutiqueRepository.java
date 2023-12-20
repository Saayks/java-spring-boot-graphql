package com.example.graphql.repositories;

import com.example.graphql.entities.StockBoutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockBoutiqueRepository extends JpaRepository<StockBoutique, Integer> {
    // Custom query methods can be added here
}
