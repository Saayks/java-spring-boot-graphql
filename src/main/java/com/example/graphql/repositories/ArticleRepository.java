package com.example.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    // Custom query methods can be added here
}
