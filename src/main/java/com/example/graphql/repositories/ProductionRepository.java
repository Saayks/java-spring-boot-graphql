package com.example.graphql.repositories;

import com.example.graphql.entities.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Integer> {
    // Custom query methods can be added here
}
