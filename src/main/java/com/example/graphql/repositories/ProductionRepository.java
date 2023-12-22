package com.example.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.model.Production;


@Repository
public interface ProductionRepository extends JpaRepository<Production, Integer> {
    // Custom query methods can be added here
}
