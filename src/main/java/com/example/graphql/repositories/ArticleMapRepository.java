package com.example.graphql.repositories;

import com.example.graphql.model.ArticleMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMapRepository extends JpaRepository<ArticleMap, Integer> {
}
