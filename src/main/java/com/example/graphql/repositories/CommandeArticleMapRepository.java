package com.example.graphql.repositories;

import com.example.graphql.model.CommandeArticleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeArticleMapRepository extends JpaRepository<CommandeArticleMap, Long> {
    // Custom query methods can be added here
}
